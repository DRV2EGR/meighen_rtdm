val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "service_builder_kubernetes",
//    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.apache.kafka" % "kafka-clients" % "2.3.1",
      "com.goyeau" %% "kubernetes-client" % "0.9.0",
      "org.slf4j" % "slf4j-simple" % "1.7.21",
      "io.fabric8" % "kubernetes-client" % "6.4.1",
      "io.circe" %% "circe-core" % "0.14.3",
      "io.circe" %% "circe-generic" % "0.14.3",
      "io.circe" %% "circe-parser" % "0.14.3"
    )
  )

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _*) => MergeStrategy.discard
  case _                        => MergeStrategy.first
}
