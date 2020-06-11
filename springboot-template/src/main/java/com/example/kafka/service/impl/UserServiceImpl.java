package com.example.kafka.service.impl;

import com.example.kafka.mapper.UserDAO;
import com.example.kafka.model.User;
import com.example.kafka.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    @Transactional
    public List<User> findByName(String name) {
        List<User> ceshi = userDAO.findByName("ceshi");
        return ceshi;
    }
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void saveUser(){
        User user = new User();
        user.setName("ceshi");
        userDAO.save(user);
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        logger.info(Thread.currentThread().getName());
        //throw new RuntimeException("ceshi");
    }

    @Override
    public String getUser(Long id) {
        User one = userDAO.getOne(id);
        System.out.println(one.getName());
        if(one != null){
            System.out.println(Thread.currentThread().getName()+one.getId());
        }else{
            System.out.println(Thread.currentThread().getName()+id+"为null");
        }
        return one.getId().toString();
    }
}
