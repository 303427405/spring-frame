package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.Role;
import com.edu.demo.pojo.entity.userRole;

import java.util.List;

public interface userRoleMapper {

    int insertSelective(userRole record);

    userRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(userRole record);
}