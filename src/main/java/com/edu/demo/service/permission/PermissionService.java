package com.edu.demo.service.permission;

import com.edu.demo.pojo.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/16
 */
public interface PermissionService {

    List<Permission> selectByRoleIds(List<Long> roleId);

    List<String> selectPermissionByRoleIds(List<Long> roleId);

}
