package com.vhp.producer.amqp.impl;

import com.vhp.producer.amqp.AmqpProducer;
import com.vhp.producer.dto.MessageDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProducerRabbitMQ implements AmqpProducer<MessageDTO> {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing_key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(MessageDTO messageDTO) {
        try {
            rabbitTemplate.convertAndSend(exchange, queue, messageDTO);
        }catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
