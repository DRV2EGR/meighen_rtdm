package io.meighen.service_bulder.service.consumers;

import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.meighen.service_bulder.docker.BuildImage;
import io.meighen.service_bulder.service.builders.Builder_SQL;
import io.meighen.service_bulder.service.builders.Template;
import io.meighen.service_bulder.service.deployers.MainDeployer;
import io.meighen.service_bulder.service.producers.KafkaProducer;
import io.meighen.service_bulder.service.producers.TemplateCreateDeployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    Builder_SQL builderSql;

    @Autowired
    MainDeployer mainDeployer;

    @Autowired
    Template template;

    @Autowired
    KafkaProducer kafkaProducer;

    @KafkaListener(topics = "create_topic",
            groupId = "group_id")
    public void consume(String message) throws IOException, URISyntaxException {
        // Print statement
        System.out.println("message = " + message);
        String name = builderSql.build(message);

        TemplateCreateDeployment temp = mainDeployer.build(name.toLowerCase());

        // Внимание, хардкод!
        // Сделано исключительно для локального запуска.
        temp.setRegistry_host("host.minikube.internal:31000"); // TODO: изменить при выкатке на другой реджистри

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        kafkaProducer.createDeployment(
                ow.writeValueAsString(temp)
        );

    }

    @KafkaListener(topics = "test_topic",
            groupId = "group_id")
    public void consumeTest(String message) throws URISyntaxException, IOException {
        // Print statement
        System.out.println("message = " + message);
//        mainDeployer.deploy(message.toLowerCase());
        template.execute();
    }
}