package com.example.demo.controller;

import com.alibaba.fastjson.JSON;

import com.example.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    public String test(){
        Object name = redisUtils.get("name");
        String name2 = JSON.toJSONString(name);
        redisUtils.set("name","123");
        return name2;

    }


}
