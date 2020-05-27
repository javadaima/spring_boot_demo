package com.example.kafka.controller;


import com.example.kafka.service.KafkaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    KafkaTestService kafkaTestService;

    @GetMapping("/kafka/test1")
    public void sendFoo() {
        for (int i = 0; i < 5000; i++) {
            kafkaTestService.sendMessage("ceshi"+i);
        }
    }
}
