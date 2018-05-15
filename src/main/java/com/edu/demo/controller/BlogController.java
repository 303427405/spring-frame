package com.edu.demo.controller;

import com.edu.demo.mapper.BlogDetailMapper;
import com.edu.demo.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String find(ModelMap modelMap , Long dicId){
        modelMap.addAttribute("blogs" , blogService.selectByDicId(dicId));
        return "/blog/view";
    }


    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(ModelMap modelMap , Long id){
        modelMap.addAttribute("blogDetail" , blogService.selectByPrimaryKey(id));
        return "/blog/detail";
    }



}
