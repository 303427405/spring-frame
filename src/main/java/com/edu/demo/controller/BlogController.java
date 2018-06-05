package com.edu.demo.controller;

import com.edu.demo.mapper.BlogDetailMapper;
import com.edu.demo.pojo.vo.BlogVO;
import com.edu.demo.scene.BlogSceneService;
import com.edu.demo.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

/**
 * Created By zhangyufei on 2018/5/9
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogSceneService blogSceneService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String find(ModelMap modelMap , Long dicId){
        modelMap.addAttribute("blogs" , blogService.selectByDicId(dicId));
        return "/blog/view";
    }


    @RequestMapping(value = "/todetail", method = RequestMethod.GET)
    public String todetail(){
        return "/blog/detail";
    }


    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Object detail(Long id){
        return blogService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/toadd", method = RequestMethod.GET)
    public String toAdd(ModelMap modelMap , Long id){
        return "/blog/add";
    }


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(BlogVO blogVO){
        blogSceneService.addBlog(blogVO);
        return Boolean.TRUE;
    }

}
