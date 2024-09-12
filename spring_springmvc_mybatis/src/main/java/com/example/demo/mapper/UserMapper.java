package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

     User getUserById(@Param("id") String id);

}
