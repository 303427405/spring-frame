package com.edu.demo.service.user;

import com.edu.demo.pojo.entity.User;

/**
 * Created By zhangyufei on 2018/5/9
 */
public interface UserService {

    User selectByPrimaryKey(Integer userId);

}
