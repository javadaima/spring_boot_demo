package com.example.kafka.controller;

import com.example.kafka.service.KafkaTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaTestService kafkaTestService;

    @RequestMapping("/testKafka")
    public void test1(){
        kafkaTestService.sendMessage("ceshi");
    }
}
