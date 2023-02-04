package io.meighen.service_bulder.kubernetes.MyKuber;

import java.util.Collections;
import java.util.HashMap;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateDeployment {
    private static final Logger logger = LoggerFactory.getLogger(CreateDeployment.class);

    public void create(String name, String imgFrom, int containerPort) {
        try (KubernetesClient client = new KubernetesClientBuilder().build()) {
            Deployment deployment = new DeploymentBuilder()
                    .withNewMetadata()
                    .withName(name)
                    .endMetadata()
                    .withNewSpec()
                    .withReplicas(1)
                    .withNewSelector()
                    .withMatchLabels(Collections.singletonMap("app", name.toLowerCase()))
                    .endSelector()
                    .withNewTemplate()
                    .withNewMetadata()
                    .withLabels(Collections.singletonMap("app", name.toLowerCase()))
                    .endMetadata()
                    .withNewSpec()
//                    .withImagePullSecrets(Collections.singletonList(new LocalObjectReference("regcred")))
                    .addNewContainer()
                    .withName(name)
                    .withImage(imgFrom)
                    .addNewPort()
                    .withContainerPort(containerPort)
                    .endPort()
                    .withEnv(
                            new EnvVar[]{
                                    new EnvVar("KAFKA_URL", "kafka", null),
                                    new EnvVar("DB_HOST", "postgres", null),
                                    new EnvVar("DB_PORT", "5432", null),
                                    new EnvVar("DB_NAME", "klusterdb", null),
                                    new EnvVar("DB_USERNAME", "postgres", null),
                                    new EnvVar("DB_PASSWORD", "nopass", null),
                                    new EnvVar("KEY_DWNLD_PATH", "", null)
                            }
                    )
                    .withImagePullPolicy("Always")
                    .endContainer()
                    .endSpec()
                    .endTemplate()
                    .endSpec()
                    .build();

            deployment = client.apps().deployments().inNamespace(client.getNamespace()).create(deployment);
            logger.info("Created deployment: {}", deployment);
        }

    }
}
