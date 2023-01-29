package io.meighen.service_bulder.service.consumers;

import io.meighen.service_bulder.service.builders.Builder_SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    Builder_SQL builderSql;

    @KafkaListener(topics = "create_topic",
            groupId = "group_id")
    public void consume(String message)
    {
        // Print statement
        System.out.println("message = " + message);
        builderSql.build(message);
    }
}