package com.edu.demo.controller;

import com.edu.demo.service.blog.BlogService;
import com.edu.demo.service.dictionary.DictionaryService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created By zhangyufei on 2018/5/9
 */
@Controller
@RequestMapping(value = "/dict")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Object dictList(){
        return dictionaryService.selectList();
    }


}
