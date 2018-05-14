package com.edu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

/**
 * Created By zhangyufei on 2018/5/9
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String find(ModelMap modelMap , RequestContext req){
        return "/blog/view";
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(ModelMap modelMap , RequestContext req){
        return "/blog/detail";
    }



}
