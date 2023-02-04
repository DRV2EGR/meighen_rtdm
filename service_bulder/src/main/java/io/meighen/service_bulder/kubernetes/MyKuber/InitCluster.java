package io.meighen.service_bulder.kubernetes.MyKuber;

import java.util.Collections;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitCluster {
    private static final Logger logger = LoggerFactory.getLogger(CreateDeployment.class);

    public static void main(String[] args) {
        try (KubernetesClient client = new KubernetesClientBuilder().build()) {
            Secret secret = new Secret();
            secret.setApiVersion("v1");

            secret.setData(
                    Collections.singletonMap(".dockerconfigjson",
                            "eyJhdXRocyI6eyJsb2NhbGhvc3Q6NTAwMCI6eyJ1c2VybmFtZSI6ImN1c3RvbWVyIiwicGFzc3dvcmQiOiJjdXN0b21lciIsImF1dGgiOiJZM1Z6ZEc5dFpYSTZZM1Z6ZEc5dFpYST0ifX19")
            );
            secret.setKind("Secret");
            secret.setType("kubernetes.io/dockerconfigjson");

            final ObjectMeta metadata = new ObjectMeta();
            metadata.setNamespace(client.getNamespace());
            metadata.setName("regcred");
//            metadata.setLabels(normalizeLabels(labels));
            secret.setMetadata(metadata);

            secret = client.secrets().inNamespace(client.getNamespace()).create(secret);
            logger.info("Created secret: {}", secret);
        }
    }
}
