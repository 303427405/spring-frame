package com.edu.demo.service.permission.impl;

import com.edu.demo.mapper.PermissionMapper;
import com.edu.demo.pojo.entity.Permission;
import com.edu.demo.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/16
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectByRoleIds(List<Long> roleId) {
        return permissionMapper.selectByRoleIds(roleId);
    }

    @Override
    public List<String> selectPermissionByRoleIds(List<Long> roleId) {
        return permissionMapper.selectPermissionByRoleIds(roleId);
    }
}
