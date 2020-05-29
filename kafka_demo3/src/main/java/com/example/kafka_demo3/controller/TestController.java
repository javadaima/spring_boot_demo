package com.example.kafka_demo3.controller;

import com.example.kafka_demo3.mapper.UserDAO;
import com.example.kafka_demo3.model.User;
import com.example.kafka_demo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private com.example.kafka_demo3.mapper.UserDAO2 UserDAO2;
    @Autowired
    private UserService userService;

    @RequestMapping("/jemeter1")
    public void test1() throws InterruptedException {
        Thread thread = Thread.currentThread();
        //thread.sleep(1000);
        System.out.println(thread.getName());
    }
    @RequestMapping("/addOrder")
    public void addOrder(){
        User user = new User();
        List<User> byName = userDAO.findByName("");
        List<User> ceeshi = userService.findByName("ceeshi");
    }

    @RequestMapping("/getUser")
    public void getUser(){
      /*  User user = new User();
        user.setName("xiam2010");
        userDAO.save(user);*/
        for (int i = 0; i < 10000; i++) {
            List<User> xiam2010 = userDAO.findByName("xiam2010");
            System.out.println(i);
        }

    }

}
