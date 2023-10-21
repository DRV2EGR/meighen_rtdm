package io.meighen.service_bulder.service.builders;

import java.io.IOException;
import java.net.URISyntaxException;

import io.meighen.service_bulder.kubernetes.MyKuber.CreateDeployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TemplateConsumer {
    private static final Logger logger = LoggerFactory.getLogger(CreateDeployment.class);

    @Autowired
    Template template;

//    @SendTo
//    @KafkaListener(topics = "create_topic",
//            groupId = "group_id")
//    public void consume(String message) {
//        // Print statement
//        System.out.println("message = " + message);
//        template.execute();
//    }
}
