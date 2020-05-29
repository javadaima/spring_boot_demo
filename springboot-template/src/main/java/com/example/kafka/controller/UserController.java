package com.example.kafka.controller;


import com.example.kafka.mapper.UserDAO;
import com.example.kafka.model.User;
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
        userService.getUser(id);
    }


}
