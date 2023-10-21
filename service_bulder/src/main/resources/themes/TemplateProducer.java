package {$package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TemplateProducer {
    private static final Logger logger = LoggerFactory.getLogger(TemplateProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void callNext(String message) {
        logger.info("Producing the message: " + message);
        kafkaTemplate.send({$topic_next}, message);
    }
}
