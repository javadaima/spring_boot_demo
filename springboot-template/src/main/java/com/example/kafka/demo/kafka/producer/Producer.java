package com.example.kafka.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class Producer {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping("/send2/{input}")
    public void sendFoo(@PathVariable String input) {
        this.template.send("tsct-app-log", input);
    }
}
