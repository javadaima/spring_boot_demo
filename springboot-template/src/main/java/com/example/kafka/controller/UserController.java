package com.example.kafka.controller;


import com.example.kafka.model.User;
import com.example.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/updateUser")
    public void updateUser(@RequestParam("id")Long id, @RequestBody User user){
        userService.updateUser(user,id);
    }



}
