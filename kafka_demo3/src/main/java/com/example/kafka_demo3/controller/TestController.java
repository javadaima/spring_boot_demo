package com.example.kafka_demo3.controller;

import com.example.kafka_demo3.mapper.UserDAO;
import com.example.kafka_demo3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserDAO UserDAO;

    @RequestMapping("/jemeter1")
    public void test1() throws InterruptedException {
        Thread thread = Thread.currentThread();
        //thread.sleep(1000);
        System.out.println(thread.getName());
    }
    @RequestMapping("/addOrder")
    public void addOrder(){
        User user = new User();
        UserDAO.save(user);
    }

}
