package com.vhp.spring.consumer.service;

import com.vhp.spring.consumer.dto.MessageDTO;

public interface ConsumerService {
    void action(MessageDTO dto) throws Exception;
}
