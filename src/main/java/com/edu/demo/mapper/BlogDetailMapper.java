package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.BlogDetail;

public interface BlogDetailMapper {

    int insertSelective(BlogDetail record);

    BlogDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogDetail record);


}