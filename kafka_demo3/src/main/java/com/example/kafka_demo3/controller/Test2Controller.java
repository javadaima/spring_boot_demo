package com.example.kafka_demo3.controller;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class Test2Controller {

    @KafkaListener(id = "webGroup", topics = "test_topic",groupId = "group1")
   /* public void listen(String input) {
        System.out.println("input2 value: {}"+input);
    }*/
    public void consumerListener(List<ConsumerRecord> consumerRecords, Acknowledgment ack) {
        ack.acknowledge();//直接提交offset
        System.out.println("input1 value: {}");
    }
}
