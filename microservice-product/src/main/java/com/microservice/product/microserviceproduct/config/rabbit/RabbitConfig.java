package com.microservice.product.microserviceproduct.config.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${rabbit.exchange.name}")
    private String exchange;

    @Value("${rabbit.exchange.routingKey.product-stock}")
    private String routingKeyProductStock;

    @Value("${rabbit.exchange.queue.product-stock}")
    private String queueProductStock;

    @Bean
    public TopicExchange productTopcExchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue productStockMq(){
        return new Queue(queueProductStock,true);
    }

    @Bean
    public Binding productStockMqBinding(TopicExchange topicExchange){
        return BindingBuilder.bind(productStockMq())
                .to(topicExchange)
                .with(routingKeyProductStock);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
