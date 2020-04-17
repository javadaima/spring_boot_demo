package com.example.kafka_demo3.controller;


import com.alibaba.fastjson.JSON;
import com.example.kafka_demo3.model.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<Object, Object> template;
    private Gson gson = new GsonBuilder().create();

    @GetMapping("/kafka/test1")
    public void sendFoo() {

        Order order = new Order();
        order.setId(123);
        order.setOrderNum("CESHI000000001");
        //order.setCreateDate(new Date());
        String message = JSON.toJSONString(order);
        this.template.send("test1", message);
    }
    @KafkaListener(topics = "test_topic",groupId = "webGroup")
    public void listen(String input, Acknowledgment ack) {
        ack.acknowledge();
        System.out.println("input1 value: {}"+input);
    }
}
