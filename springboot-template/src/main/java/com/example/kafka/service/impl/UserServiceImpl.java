package com.example.kafka.service.impl;

import com.example.kafka.mapper.UserDAO;
import com.example.kafka.model.User;
import com.example.kafka.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

@Service("11")
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

    @Override
    public void updateUser(User user,Long id) {
        Optional<User> byId = userDAO.findById(id);
        if(byId.isPresent()){
            User user1 = byId.get();
            BeanUtils.copyProperties(user,user1,new String[]{"id"});
            userDAO.save(user1);
        }

    }
}
