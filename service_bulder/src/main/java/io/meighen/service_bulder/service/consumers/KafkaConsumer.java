package io.meighen.service_bulder.service.consumers;

import java.io.IOException;
import java.net.URISyntaxException;

import io.meighen.service_bulder.docker.BuildImage;
import io.meighen.service_bulder.service.builders.Builder_SQL;
import io.meighen.service_bulder.service.builders.Template;
import io.meighen.service_bulder.service.deployers.MainDeployer;
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

    @KafkaListener(topics = "create_topic",
            groupId = "group_id")
    public void consume(String message) throws IOException, URISyntaxException {
        // Print statement
        System.out.println("message = " + message);
        builderSql.build(message);
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