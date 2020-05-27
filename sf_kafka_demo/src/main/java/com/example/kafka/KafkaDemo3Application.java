package com.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.kafka.mapper")
public class KafkaDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemo3Application.class, args);
    }

}
