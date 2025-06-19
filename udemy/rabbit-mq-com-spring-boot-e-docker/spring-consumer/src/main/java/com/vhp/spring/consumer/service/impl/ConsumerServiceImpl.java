package com.vhp.spring.consumer.service.impl;

import com.vhp.spring.consumer.dto.MessageDTO;
import com.vhp.spring.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(MessageDTO messageDTO) throws Exception {
        System.out.println(messageDTO.getText());
    }
}
