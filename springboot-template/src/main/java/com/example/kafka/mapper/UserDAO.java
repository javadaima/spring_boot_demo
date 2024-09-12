package com.example.kafka.mapper;


import com.example.kafka.model.User;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@EnableAspectJAutoProxy(exposeProxy=true)
public interface UserDAO extends JpaRepository<User,Long> {
    List<User> findByName(String name);
    /*
    * 我们在这里直接继承 JpaRepository
    * 这里面已经有很多现场的方法了
    * 这也是JPA的一大优点
    *
    * */
}