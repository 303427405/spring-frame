package com.edu.demo.service.role;

import com.edu.demo.pojo.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/16
 */
public interface RoleService {


    /**
     * @param userId
     * @return
     */
    List<Role> selectByUserId( long userId);


    /**
     * @param userId
     * @return
     */
    List<Long> selectRoleIdByUserId(long userId);


    List<String> selectRoleByUserId(long userId);

}
