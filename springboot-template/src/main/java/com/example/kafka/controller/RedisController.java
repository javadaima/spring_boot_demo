package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/readRedis")
    public void testRedis(@RequestParam("id") Long id){
        Object test20200529 = redisTemplate.opsForValue().get("test20200529"+id);
        System.out.println(124);
    }

    @RequestMapping("/writeRedis")
    public void writeRedis(@RequestParam("id") Long id){
        redisTemplate.opsForValue().set("test20200529"+id,"test20200529"+id);
        System.out.println(124);
    }



}
