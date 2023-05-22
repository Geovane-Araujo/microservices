package com.microservice.product.microserviceproduct.config.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer {

    @RabbitListener(queues = "product-stock")
    public void receiveMessage(String message){

    }
}
