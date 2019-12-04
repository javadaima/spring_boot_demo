package com.example.demo.controller;



import com.alibaba.fastjson.JSON;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public String getUser(String id){
        User user = userService.getUserById(id);
        return JSON.toJSONString(user);
    }


}
