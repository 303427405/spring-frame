package com.edu.demo.scene.impl;

import com.edu.demo.pojo.entity.Blog;
import com.edu.demo.pojo.entity.BlogDetail;
import com.edu.demo.pojo.vo.BlogVO;
import com.edu.demo.scene.BlogSceneService;
import com.edu.demo.service.blog.BlogDetailService;
import com.edu.demo.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By zhangyufei on 2018/5/29
 */
@Service("blogSceneService")
public class BlogSceneServiceImpl implements BlogSceneService{

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogDetailService blogDetailService;

    @Override
    public Boolean addBlog(BlogVO blogVO) {
        /**保存日志*/
        Blog blog = new Blog();
        blog.setDescription(blogVO.getDescription());
        blog.setDicId(blogVO.getSkill());
        blog.setName(blogVO.getName());
        blogService.insertSelective(blog);

        BlogDetail blogDetail = new BlogDetail();
        blogDetail.setName(blogVO.getName());
        blogDetail.setBlogId(blog.getId());
        blogDetail.setDescription(blogVO.getContent());
        blogDetail.setDicId(blogVO.getSkill());
        blogDetailService.insertSelective(blogDetail);
        return true;
    }
}
