package com.example.kafka.controller;

import com.example.kafka.mapper.UserDAO;
import com.example.kafka.mapper.UserMapper;
import com.example.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("mybatis")
@RestController
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/test")
    public void test1(@RequestParam("id")String id) throws Exception {
        User userById = userMapper.getUserById(id);
        System.out.println(userById.getName());
    }
    @RequestMapping("/test2")
    public void test2(@RequestParam("id")String id){
        //User user = userDAO.getOne(new Long(id));
        User user = new User();
        user.setName("1616");
        user.setPassword("123456");
        User save = userDAO.save(user);
    }

    @RequestMapping("/test3")
    public void test3(@RequestParam("id")String id){
        List<User> byName = userDAO.findByName("1616");
        User user1 = byName.get(0);
        System.out.println(user1.getPassword());

    }



}
