package {$package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

{$imports}

@Component
public class TemplateConsumer {
    private static final Logger logger = LoggerFactory.getLogger(TemplateConsumer.class);

    {$autowired}

    @KafkaListener(topics = "{$topic}",
            groupId = "group_id")
    public void consume(String message) {
        logger.info("Get message: " + message);
        {$script_calls}

        {$return_message}
    }
}
