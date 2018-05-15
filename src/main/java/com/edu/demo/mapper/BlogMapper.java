package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Long id);

    List<Blog> selectByDicId(@Param("dicId") Long dicId);

    int updateByPrimaryKeySelective(Blog record);
}