package com.edu.demo.service.role.impl;

import com.edu.demo.mapper.RoleMapper;
import com.edu.demo.pojo.entity.Role;
import com.edu.demo.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/16
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectByUserId(long userId) {
        return roleMapper.selectByUserId(userId);
    }

    @Override
    public List<Long> selectRoleIdByUserId(long userId) {
        return roleMapper.selectRoleIdByUserId(userId);
    }

    @Override
    public List<String> selectRoleByUserId(long userId) {
        return roleMapper.selectRoleByUserId(userId);
    }
}
