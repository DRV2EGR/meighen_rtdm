package io.meighen.service_bulder.kubernetes;

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;

public class CreateService {

    private static final Logger logger = LoggerFactory.getLogger(CreateService.class);

    public static void main(String[] args) {
        try (KubernetesClient client = new KubernetesClientBuilder().build()) {
            String namespace = Optional.ofNullable(client.getNamespace()).orElse("default");
            if (args.length > 0) {
                namespace = args[0];
            }
            Service service = new ServiceBuilder()
                    .withNewMetadata()
                    .withName("my-service-2")
                    .endMetadata()
                    .withNewSpec()
                    .withSelector(Collections.singletonMap("app", "MyApp"))
                    .addNewPort()
                    .withName("test-port")
                    .withProtocol("TCP")
                    .withPort(80)
                    .withTargetPort(new IntOrString(9376))
                    .endPort()
                    .withType("LoadBalancer")
                    .endSpec()
                    .build();

            service = client.services().inNamespace(namespace).create(service);
            logger.info("Created service with name {}", service.getMetadata().getName());

            String serviceURL = client.services().inNamespace(namespace).withName(service.getMetadata().getName())
                    .getURL("test-port");
            logger.info("Service URL {}", serviceURL);
        }
    }
}