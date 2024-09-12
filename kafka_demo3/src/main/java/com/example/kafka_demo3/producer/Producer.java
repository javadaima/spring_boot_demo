package com.example.kafka_demo3.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping("/send2/{input}")
    public void sendFoo(@PathVariable String input) {
        this.template.send("test1", input);
    }
    @KafkaListener(topics = "test1",groupId = "group1")
    public void listen(String input) {
        System.out.println("input1 value: {}"+input);
    }


}
