package services

import io.fabric8.kubernetes.api.model.{DeletionPropagation, EnvVar}
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder
import io.fabric8.kubernetes.client.{Config, ConfigBuilder, KubernetesClient, KubernetesClientBuilder}

import java.util.Collections

class KuberDeployment_S {

  def delete(name: String): Unit = {
    val config = new ConfigBuilder().withMasterUrl("https://127.0.0.1:2868").build
    try {
      val client = new KubernetesClientBuilder().build
      try {
        client.apps.deployments.inNamespace(client.getNamespace).withName(name).withPropagationPolicy(DeletionPropagation.FOREGROUND).delete
        while (client.apps.deployments.inNamespace(client.getNamespace).withName(name).get != null) {
          println("Waiting deleting of " + name + " ...")
//          logger.info("Waiting deleting of " + name + " ...")
          Thread.sleep(1000)
        }
      } catch {
        case e: InterruptedException =>
          throw new RuntimeException(e)
      } finally if (client != null) client.close()
    }
  }

  def create(name: String, imgFrom: String, containerPort: Integer): Unit = {
    val config = new ConfigBuilder().withMasterUrl("https://127.0.0.1:2868").build

    try {
      val client = new KubernetesClientBuilder().withConfig(config).build
      try {
        var deployment = new DeploymentBuilder()
          .withNewMetadata
            .withName(name)
          .endMetadata
          .withNewSpec
            .withReplicas(1)
            .withNewSelector
            .withMatchLabels(Collections.singletonMap("app", name.toLowerCase))
          .endSelector
          .withNewTemplate
            .withNewMetadata
              .withLabels(Collections.singletonMap("app", name.toLowerCase))
            .endMetadata
            .withNewSpec
            .addNewContainer
              .withName(name)
              .withImage(imgFrom)
                .addNewPort
                  .withContainerPort(containerPort)
                .endPort
                .withEnv(java.util.Arrays.asList(Array[EnvVar](
                  new EnvVar("KAFKA_URL", "kafka", null),
                  new EnvVar("DB_HOST", "postgres", null),
                  new EnvVar("DB_PORT", "5432", null),
                  new EnvVar("DB_NAME", "klusterdb", null),
                  new EnvVar("DB_USERNAME", "postgres", null),
                  new EnvVar("DB_PASSWORD", "nopass", null),
                  new EnvVar("KEY_DWNLD_PATH", "", null)).toList:_*)
                )
                .withImagePullPolicy("Always")
            .endContainer
          .endSpec
          .endTemplate
          .endSpec.build

        deployment = client.apps.deployments.inNamespace(client.getNamespace).create(deployment)
//        logger.info("Created deployment: {}", deployment)
      } finally if (client != null) client.close()
    }
  }
}
