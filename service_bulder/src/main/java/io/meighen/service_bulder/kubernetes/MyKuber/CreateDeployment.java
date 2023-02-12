package io.meighen.service_bulder.kubernetes.MyKuber;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreateDeployment {
    private static final Logger logger = LoggerFactory.getLogger(CreateDeployment.class);

    @Value("${kubernetes.cluster.ip}")
    String klusterIP = "ip172-18-0-14-cfgkrhv0jk6g00eekvtg.direct.labs.play-with-k8s.com";

    public static void main(String[] args) {
        CreateDeployment cd = new CreateDeployment();
        cd.create("newname", "drv2vna/etobaza", 8082);
    }

    public void create(String name, String imgFrom, int containerPort) {

//        KubernetesClient client = new DefaultKubernetesClient(new ConfigBuilder()
//                .withTrustCerts(true)
//                .withMasterUrl("ip172-18-0-14-cfgkrhv0jk6g00eekvtg.direct.labs.play-with-k8s.com")
////                .withOauthToken(OAUTH_TOKEN)
//                .build());

//        Config config = new ConfigBuilder().withMasterUrl(klusterIP).build();
//        config.setMasterUrl("ip172-18-0-14-cfgkrhv0jk6g00eekvtg.direct.labs.play-with-k8s.com");
//                new ConfigBuilder()
////                .withTrustCerts(true)
//                .withMasterUrl("ip172-18-0-14-cfgkrhv0jk6g00eekvtg.direct.labs.play-with-k8s.com")
//                .build();

        try ( KubernetesClient client = new KubernetesClientBuilder().build() ) {
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
