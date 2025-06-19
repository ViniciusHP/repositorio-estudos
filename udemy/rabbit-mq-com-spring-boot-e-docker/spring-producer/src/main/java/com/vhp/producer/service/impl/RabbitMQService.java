package com.vhp.producer.service.impl;

import com.vhp.producer.amqp.AmqpProducer;
import com.vhp.producer.dto.MessageDTO;
import com.vhp.producer.service.AmqpService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RabbitMQService implements AmqpService<MessageDTO> {

    @Autowired
    AmqpProducer<MessageDTO> amqp;

    @Override
    public void sendToConsumer(MessageDTO messageDTO) {
        amqp.producer(messageDTO);
    }
}
