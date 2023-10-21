package io.meighen.presenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void deployService(String message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("create_topic", message);
    }

    public void buildService(String message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("build_topic", message);
    }

    public void unDeployService(String message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("undeploy_topic", message);
    }
}
