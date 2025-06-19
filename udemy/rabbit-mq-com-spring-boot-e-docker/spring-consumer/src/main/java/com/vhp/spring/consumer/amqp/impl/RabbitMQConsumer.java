package com.vhp.spring.consumer.amqp.impl;

import com.vhp.spring.consumer.amqp.AmqpConsumer;
import com.vhp.spring.consumer.dto.MessageDTO;
import com.vhp.spring.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer implements AmqpConsumer<MessageDTO> {

    @Autowired
    ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing_key.producer}")
    public void consumer(MessageDTO messageDTO) {
        try {
            consumerService.action(messageDTO);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
