package com.edu.demo.controller;

import com.edu.demo.pojo.entity.User;
import com.edu.demo.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created By zhangyufei on 2018/5/9
 */
@Controller
@RequestMapping(value = "/user")
@Api(value = "user_api", description = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public User find(@RequestParam(value = "userId" , required = true)  Integer userId){
        return userService.selectByPrimaryKey(userId);
    }


    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
//        return userService.selectByPrimaryKey(userId);
        return null;
    }


}
