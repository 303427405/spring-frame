package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    List<Permission> selectByRoleIds(@Param("roleId") List<Long> roleId);

    List<String> selectPermissionByRoleIds(@Param("roleId") List<Long> roleId);

}