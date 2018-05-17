package com.edu.demo.service.user.impl;

import com.edu.demo.mapper.UserMapper;
import com.edu.demo.pojo.entity.User;
import com.edu.demo.service.user.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By zhangyufei on 2018/5/9
 */
@Service("userService")
@MapperScan(basePackages = "com.edu.demo.mapper.**")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
