package com.example.kafka.controller;


import com.example.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public void saveUser(){
        userService.saveUser();
    }

    @RequestMapping("/getUser")
    public void getUser(@RequestParam("id")Long id){
        String user = userService.getUser(id);
        System.out.println(user);
    }


}
