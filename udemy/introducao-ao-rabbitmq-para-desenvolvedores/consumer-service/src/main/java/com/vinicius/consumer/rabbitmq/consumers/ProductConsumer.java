package com.vinicius.consumer.rabbitmq.consumers;

import com.vhp.rabbitmq.dtos.ProductDTO;
import constants.RabbitMQConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ProductConsumer {

    @RabbitListener(queues = {RabbitMQConstants.QUEUE_PRODUCT_LOG})
    public void consumer(ProductDTO dto) {
        log.info("Received message " + dto.toString());
    }
}
