package com.edu.demo.service.dictionary.impl;

import com.edu.demo.mapper.DictionaryMapper;
import com.edu.demo.mapper.UserMapper;
import com.edu.demo.pojo.entity.Dictionary;
import com.edu.demo.service.dictionary.DictionaryService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/14
 */
@Service("dictionaryService")
@MapperScan(basePackages = "com.edu.demo.mapper.**")
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> selectList() {
        return dictionaryMapper.selectList();
    }
}
