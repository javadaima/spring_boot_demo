package com.example.kafka.service;

import com.example.kafka.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> findByName(String name);

    @Transactional
    void saveUser();

    String getUser(Long id);

    void updateUser(User user,Long id);
}
