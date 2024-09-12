package com.example.kafka_demo3.controller;


import com.alibaba.fastjson.JSON;
import com.example.kafka_demo3.model.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ConsumerController {

    @KafkaListener(topics = "test_topic",groupId = "group1")
   /* public void listen(String input) {
        System.out.println("input2 value: {}"+input);
    }*/
    public void consumerListener(List<String> consumerRecords, Acknowledgment ack) {
        ack.acknowledge();//直接提交offset
        System.out.println(123);
        for(String consumerRecord:consumerRecords){
            System.out.println("input1 value: {}"+consumerRecord);
        }

    }

    @KafkaListener(topics = "test1",groupId = "group1")
   /* public void listen(String input) {
        System.out.println("input2 value: {}"+input);
    }*/
    public void consumerListener2(ConsumerRecord<Object,Order> consumerRecord, Acknowledgment ack) {
        /*ack.acknowledge();//直接提交offset
        Gson gson = new GsonBuilder().create();
        System.out.println(123);
        System.out.println("input1 value: {}"+order);
*/

        Optional<Order> orderOptional = Optional.ofNullable(consumerRecord.value());
        if(orderOptional.isPresent()){
            /*String order = orderOptional.get();
            Order parse = JSON.parseObject(order,Order.class);*/
            Order order = orderOptional.get();
            System.out.println("kafka消费消息"+order);
        }
    }

    public static void main(String[] args) {
        int abs = Math.abs("group1".hashCode());
        int i = abs % 50;
        System.out.println(i);
    }
}
