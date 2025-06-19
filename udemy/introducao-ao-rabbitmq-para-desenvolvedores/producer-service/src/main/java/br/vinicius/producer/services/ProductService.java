package br.vinicius.producer.services;

import br.vinicius.producer.configs.RabbitMQConfig;
import com.vhp.rabbitmq.dtos.ProductDTO;
import constants.RabbitMQConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final RabbitTemplate rabbitTemplate;

    public void createProduct(ProductDTO dto) {
        log.info("Sending a message to exchange " + dto.toString());
        rabbitTemplate.convertAndSend(RabbitMQConstants.EXG_NAME_MARKETPLACE, RabbitMQConstants.RK_PRODUCT_LOG, dto);
    }
}
