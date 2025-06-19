package com.vinicius.consumer.rabbitmq.config;

import com.vhp.rabbitmq.dtos.ProductDTO;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RabbitMQConfig {

    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of(ProductDTO.class.getCanonicalName()));
        return converter;
    }
}
