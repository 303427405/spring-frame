package com.edu.demo.service.blog.impl;

import com.edu.demo.mapper.BlogDetailMapper;
import com.edu.demo.pojo.entity.BlogDetail;
import com.edu.demo.service.blog.BlogDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By zhangyufei on 2018/5/29
 */
@Service("blogDetailService")
public class BlogDetailServiceImpl implements BlogDetailService{

    @Autowired
    private BlogDetailMapper blogDetailMapper;

    @Override
    public int insertSelective(BlogDetail record) {
        return blogDetailMapper.insertSelective(record);
    }
}
