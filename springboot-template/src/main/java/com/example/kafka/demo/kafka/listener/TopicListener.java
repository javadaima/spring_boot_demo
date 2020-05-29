package com.example.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {
    @KafkaListener(topics = "tsct-app-log",groupId = "group1")
    public void listen(String input) {
        System.out.println("input1 value: {}"+input);
    }
}

