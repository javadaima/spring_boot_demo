package com.example.kafka.service;

import com.example.kafka.model.User;

import java.util.List;

public interface UserService {
    List<User> findByName(String name);
}
