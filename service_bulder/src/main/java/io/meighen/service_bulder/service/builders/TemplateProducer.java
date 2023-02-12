package io.meighen.service_bulder.service.builders;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.GenericMessageListenerContainer;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class TemplateProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void callNext(String message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("delete_branches", message);
    }

    public void callInternal(String message) throws ExecutionException, InterruptedException {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("delete_branches", message)
                .get();
    }
}
