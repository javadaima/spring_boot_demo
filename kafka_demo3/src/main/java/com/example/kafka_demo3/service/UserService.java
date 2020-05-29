package com.example.kafka_demo3.service;

import com.example.kafka_demo3.model.User;

import java.util.List;

public interface UserService {
    List<User> findByName(String name);
}
