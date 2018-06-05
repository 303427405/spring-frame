package com.edu.demo.service.blog.impl;

import com.edu.demo.mapper.BlogDetailMapper;
import com.edu.demo.mapper.BlogMapper;
import com.edu.demo.pojo.entity.Blog;
import com.edu.demo.pojo.entity.BlogDetail;
import com.edu.demo.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/15
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private BlogDetailMapper blogDetailMapper;

    @Override
    public List<Blog> selectByDicId(Long dicId) {
        return blogMapper.selectByDicId(dicId);
    }

    @Override
    public BlogDetail selectByPrimaryKey(Long id) {
        return blogDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Blog record) {
        return blogMapper.insertSelective(record);
    }
}
