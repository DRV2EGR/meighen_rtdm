package io.meighen.service_bulder.docker;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.command.PushImageCmd;
import com.github.dockerjava.api.model.AuthConfig;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.PushResponseItem;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.command.BuildImageResultCallback;
import com.github.dockerjava.core.command.PushImageResultCallback;
import org.apache.commons.lang.SystemUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
public class BuildImage {
    @Value("${docker.instance.url}")
    private String instanceURL;

    @Value("${docker.registry.url}")
    private String registryURL;

    public void build(String name) throws URISyntaxException, IOException {
        DockerClient dockerClient = DockerClientBuilder
                .getInstance(instanceURL)
                .build();

//        URL resource = new ClassPathResource("demo/Dockerfile").getURL();
        File dest = new File(new FileSystemResource("/tempa").getFile().getAbsolutePath());
        URL resource = dest.toURL();

        System.out.println(resource.toURI());
//
        try {
            System.out.println(String.format("\n==> %s\n",
                    dockerClient.buildImageCmd(dest)
//                        .withRemove()
                            .withTag(registryURL + "/" + name)
                            .exec(new BuildImageResultCallback())
                            .awaitImageId()
            ));
        } catch (Exception e) {
            // pass
        }

        System.out.println("BUILDED!");

//        dockerClient.tagImageCmd(
//                "c.m.batup.dj_test:0.0.1",
//                "dockertest00:5000/djt/c.m.batup.dj_test",
//                "0.0.1"
//        ).exec();

//        AuthConfig auth = new AuthConfig();
//        auth.setEmail("adam.mo...@example.com");
//        auth.setPassword("changeme");
//        auth.setUsername("c.m.batup.dj_test");
//        auth.setServerAddress("dockertest00");

        dockerClient.pushImageCmd(registryURL+"/"+name)     // <=== THIS IS LINE 58
//                .withAuthConfig(auth)
                .withName(registryURL+"/"+name)
//                .withTag("ex-ter")
                .exec(new PushImageResultCallback())
                .awaitSuccess();


//                var dockerClient
//                = DockerClientBuilder.getInstance("tcp://localhost:2375").build();
//
//        URL resource = BuildImage.class.getClassLoader().getResource("demo/Dockerfile");
//        System.out.println(resource.toURI());
//        String imageId = dockerClient.buildImageCmd()
//                .withDockerfile(new File(resource.toURI()))
//                .withPull(true)
//                .withNoCache(true)
//                .withTag("username:mydemo")
//                .exec(new BuildImageResultCallback())
//                .awaitImageId();

//        System.out.println(imageId);

//        AuthConfig auth = new AuthConfig()
//                .withRegistryAddress("http://localhost")
//                .withUsername("mydemo");

//        auth.setEmail("adam.mo...@example.com");
//        auth.setPassword("changeme");
//        auth.setUsername("c.m.batup.dj_test");
//        auth.setServerAddress("dockertest00");

//        String imageId = "99d7fe15815d";
//        PushImageCmd pushImageCmd = dockerClient.pushImageCmd("mydemo").withTag("mydemo");
//        PushImageResultCallback callback = new PushImageResultCallback() {
//            @Override
//            public void onNext(PushResponseItem item) {
//                super.onNext(item);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
////                logger.error("Failed to push image:" + throwable.getMessage());
//                System.out.println("Failed to push image:" + throwable.getMessage());
//                super.onError(throwable);
//            }
//        };
//        pushImageCmd.exec(callback).awaitSuccess();

//        String localDockerHost = SystemUtils.IS_OS_WINDOWS ? "tcp://localhost:2375" : "unix:///var/run/docker.sock";
//        DockerClient dockerClient = DockerClientBuilder.getInstance(localDockerHost).build();
//        List<Container> containers = dockerClient.listContainersCmd().exec();
//
//        for(int i=0; i < containers.size(); i++){
//            System.out.println(containers.get(i));
//        }
    }


}
