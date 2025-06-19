package com.vhp.producer.api;

import com.vhp.producer.dto.MessageDTO;
import com.vhp.producer.service.AmqpService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AmqpAPI {

    @Autowired
    AmqpService<MessageDTO> service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/send")
    public void sendToConsumer(@RequestBody MessageDTO messageDTO) {
        service.sendToConsumer(messageDTO);
    }
}
