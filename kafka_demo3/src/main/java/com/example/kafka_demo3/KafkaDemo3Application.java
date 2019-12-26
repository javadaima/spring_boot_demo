package com.example.kafka_demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemo3Application.class, args);
    }

}
