package com.edu.demo.service.user;

import com.edu.demo.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created By zhangyufei on 2018/5/9
 */
public interface UserService {

    User selectByPrimaryKey(Integer userId);

    User selectByUserName(String username);


}
