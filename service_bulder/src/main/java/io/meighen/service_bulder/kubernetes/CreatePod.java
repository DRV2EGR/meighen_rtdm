package io.meighen.service_bulder.kubernetes;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class CreatePod {

    private static final Logger logger = LoggerFactory.getLogger(CreatePod.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            logger.warn("Usage: podJsonFileName <token> <namespace>");
            return;
        }
        String fileName = "/    ";
        String namespace = null;
        if (args.length > 2) {
            namespace = args[2];
        }

        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            logger.warn("File does not exist: {}", fileName);
            return;
        }

        ConfigBuilder builder = new ConfigBuilder();
        if (args.length > 1) {
            builder.withOauthToken(args[1]);
        }
        Config config = builder.build();
        try (final KubernetesClient client = new KubernetesClientBuilder().withConfig(config).build()) {
            if (namespace == null) {
                namespace = client.getNamespace();
            }

            List<HasMetadata> resources = client.load(new FileInputStream(fileName)).get();
            if (resources.isEmpty()) {
                logger.error("No resources loaded from file: {}", fileName);
                return;
            }
            HasMetadata resource = resources.get(0);
            if (resource instanceof Pod) {
                Pod pod = (Pod) resource;
//                Pod p = new PodBuilder()
//                        .withNewMetadata();
                logger.info("Creating pod in namespace {}", namespace);
                NonNamespaceOperation<Pod, PodList, PodResource> pods = client.pods().inNamespace(namespace);
                Pod result = pods.create(pod);
                logger.info("Created pod {}", result.getMetadata().getName());
            } else {
                logger.error("Loaded resource is not a Pod! {}", resource);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}