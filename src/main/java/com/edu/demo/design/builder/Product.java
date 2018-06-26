package com.edu.demo.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式  产品类
 * Created By zhangyufei on 2018/6/19
 */
public class Product {

    /**产品部件*/
    List<String> parts = new ArrayList<>();


    public void add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println("产品部件");
        for (String part : parts){
            System.out.println(part);
        }
    }

}
