package com.example.kafka.controller;

import com.example.kafka.mapper.UserDAO;
import com.example.kafka.model.User;
import com.example.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserDAO UserDAO;
    @Autowired
    private com.example.kafka.mapper.UserDAO2 UserDAO2;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/jemeter1")
    public void test1() throws InterruptedException {
        Thread thread = Thread.currentThread();
        //thread.sleep(1000);
        System.out.println(thread.getName());
    }
    @RequestMapping("/addOrder")
    public void addOrder(){
        User user = new User();
        List<User> byName = UserDAO.findByName("");
        List<User> ceeshi = userService.findByName("ceeshi");
    }
    

    
    

}
