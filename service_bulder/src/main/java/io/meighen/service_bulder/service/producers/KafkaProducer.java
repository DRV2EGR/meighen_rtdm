package io.meighen.service_bulder.service.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void createDeployment(String message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("creating_deployments", message);
    }
}
