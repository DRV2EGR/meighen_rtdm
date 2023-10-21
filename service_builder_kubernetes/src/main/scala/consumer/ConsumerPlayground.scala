package consumer

import com.goyeau.kubernetes.client.KubernetesClient
import io.circe.{Json, ParsingFailure}

import java.time.Duration
import org.apache.kafka.clients.consumer.ConsumerConfig.*

import java.util.Properties
import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.serialization.{IntegerDeserializer, StringDeserializer}

import scala.collection.JavaConverters.*
import io.circe.*
import io.circe.parser.*
import services.KuberDeployment_S

object ConsumerPlayground extends App {
  class CC[T] { def unapply(a:Any):Option[T] = Some(a.asInstanceOf[T]) }
  object M extends CC[Map[String, Any]]

  val consumerProperties = new Properties()
  consumerProperties.setProperty(BOOTSTRAP_SERVERS_CONFIG, sys.env("KAFKA_URL"))
  consumerProperties.setProperty(GROUP_ID_CONFIG, "group-id-2")
  consumerProperties.setProperty(KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
  consumerProperties.setProperty(VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
  consumerProperties.setProperty(AUTO_OFFSET_RESET_CONFIG, "latest")
  consumerProperties.setProperty(ENABLE_AUTO_COMMIT_CONFIG, "false")

  val consumer = new KafkaConsumer[Int, String](consumerProperties)
  consumer.subscribe(List("creating_deployments", "test_3").asJava)

  println("| Key | Message | Partition | Offset |")
  while (true) {
    val polledRecords: ConsumerRecords[Int, String] = consumer.poll(Duration.ofSeconds(1))
    if (!polledRecords.isEmpty) {
      println(s"Polled ${polledRecords.count()} records")
      val recordIterator = polledRecords.iterator()
      while (recordIterator.hasNext) {
        val record: ConsumerRecord[Int, String] = recordIterator.next()
        val csvTrip = record.value()
        println(s"| ${record.topic()} | ${record.key()} | ${record.value()} | ${record.partition()} | ${record.offset()} |")

        val parseResult: Either[ParsingFailure, Json] = parse(csvTrip)

        if (record.topic() == "creating_deployments") {
          var app_name: Option[String] = null;
          var registry_host: Option[String] = null;
          var image: Option[String] = null;
          var port: Option[String] = null;

          parseResult match {
            case Left(parsingError) =>
              throw new IllegalArgumentException(s"Invalid JSON object: ${parsingError.message}")
            case Right(json) =>
              app_name = (json \\ "app_name").collectFirst { case field => field.asString }.get
              registry_host = (json \\ "registry_host").collectFirst { case field => field.asString }.get
              image = (json \\ "image").collectFirst { case field => field.asString }.get
              port = (json \\ "port").collectFirst { case field => field.asString }.get
          }


          val nrt = new KuberDeployment_S()
          nrt.delete(app_name.get.replace('_', '-'))
          nrt.create(app_name.get.replace('_', '-'), registry_host.get + "/" + image.get, Integer.parseInt(port.get))
        }


      }
    }
  }

}
