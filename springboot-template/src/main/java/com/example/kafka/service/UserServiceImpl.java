package com.example.kafka.service;

import com.example.kafka.mapper.UserDAO;
import com.example.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAO;

    @Override
    @Transactional
    public List<User> findByName(String name) {
        List<User> ceshi = userDAO.findByName("ceshi");
        return ceshi;
    }
}
