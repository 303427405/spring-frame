package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    User selectByPrimaryKey(Integer userId);

    User selectByUserName(@Param("username") String username);

}