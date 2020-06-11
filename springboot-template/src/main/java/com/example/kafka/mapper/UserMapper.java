package com.example.kafka.mapper;

import com.example.kafka.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

     User getUserById(@Param("id") String id);

}
