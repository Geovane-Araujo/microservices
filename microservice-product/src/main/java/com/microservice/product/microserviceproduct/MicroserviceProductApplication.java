package com.microservice.product.microserviceproduct;

import jdk.jfr.Enabled;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MicroserviceProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProductApplication.class, args);
    }

}
