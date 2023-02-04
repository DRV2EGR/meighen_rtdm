package io.meighen.service_bulder.kubernetes.MyKuber;

import java.util.Collections;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateService {
    private static final Logger logger = LoggerFactory.getLogger(CreateDeployment.class);

    public void create(String name) {
        try (KubernetesClient client = new KubernetesClientBuilder().build()) {
            io.fabric8.kubernetes.api.model.Service service = new io.fabric8.kubernetes.api.model.Service();
            service.setKind("Service");

            final ObjectMeta metadata = new ObjectMeta();
            metadata.setLabels(
                    Collections.singletonMap("visualize", "true")
            );
            metadata.setName(name + "-service");
            service.setMetadata(metadata);

            ServiceSpec serviceSpec = new ServiceSpec();
            serviceSpec.setSelector(Collections.singletonMap("app", name));

            ServicePort servicePort = new ServicePort();
            servicePort.setName("http");
            servicePort.setProtocol("TCP");
            servicePort.setPort(8080);
            servicePort.setTargetPort(new IntOrString(8080));
            serviceSpec.setPorts(
                    Collections.singletonList(servicePort)
            );
            serviceSpec.setType("LoadBalancer");
            service.setSpec(
                    serviceSpec
            );

            service = client.services().inNamespace(client.getNamespace()).create(service);
            logger.info("Created service: {}", service);
        }

    }
}
