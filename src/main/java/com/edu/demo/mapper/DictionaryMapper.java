package com.edu.demo.mapper;

import com.edu.demo.pojo.entity.Dictionary;

import java.util.List;

public interface DictionaryMapper {

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    List<Dictionary> selectList();

    int updateByPrimaryKeySelective(Dictionary record);
}