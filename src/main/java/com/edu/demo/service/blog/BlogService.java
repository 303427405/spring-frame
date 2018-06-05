package com.edu.demo.service.blog;

import com.edu.demo.pojo.entity.Blog;
import com.edu.demo.pojo.entity.BlogDetail;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/15
 */
public interface BlogService {

    List<Blog> selectByDicId(Long dicId);

    BlogDetail selectByPrimaryKey(Long id);

    int insertSelective(Blog record);

}
