package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);


    /**
     * @param userId
     * @return
     */
    List<Role> selectByUserId(@Param("userId") long userId);


    /**
     * @param userId
     * @return
     */
    List<Long> selectRoleIdByUserId(@Param("userId") long userId);


    List<String> selectRoleByUserId(@Param("userId") long userId);


}