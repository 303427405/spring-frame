package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.User;

public interface UserMapper {


    User selectByPrimaryKey(Integer userId);
}