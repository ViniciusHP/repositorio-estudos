package com.vinicius.consumer.rabbitmq.consumers;

import constants.RabbitMQConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumer {

    @RabbitListener(queues = {RabbitMQConstants.QUEUE_PRODUCT_LOG})
    public void consumer(String message) {
        log.info("Consumer received a message " + message);
    }
}
