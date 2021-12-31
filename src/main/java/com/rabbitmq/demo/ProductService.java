package com.rabbitmq.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public String sendMessage(Product product) {
        System.out.println("xay ra loi message");
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING, product);
        System.out.println("da luu vao hang doi message");
        return product.toString();
    }

    public Product receiver(){
        rabbitTemplate.receiveAndConvert(RabbitConfig.QUEUE);
        System.out.println("get receiver");
        return null;
    }
}
