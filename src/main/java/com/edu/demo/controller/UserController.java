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
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    public User find(@RequestParam(value = "userId" , required = true)  Integer userId){
        return userService.selectByPrimaryKey(userId);
    }


    @ResponseBody
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
//        return userService.selectByPrimaryKey(userId);
        return null;
    }


}
