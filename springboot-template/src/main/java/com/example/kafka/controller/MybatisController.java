package com.example.kafka.controller;

import com.example.kafka.mapper.UserDAO;
import com.example.kafka.mapper.UserMapper;
import com.example.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("mybatis")
@RestController
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/test")
    public void test1(@RequestParam("id")String id){
        User userById = userMapper.getUserById(id);
        System.out.println(124);
    }
    @RequestMapping("/test2")
    public void test2(@RequestParam("id")String id){
        User user = userDAO.getOne(new Long(id));
        user.setName("0611");
        userDAO.save(user);
        System.out.println(124);
    }



}
