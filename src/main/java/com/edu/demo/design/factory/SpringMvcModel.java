package com.edu.demo.design.factory;

import com.edu.demo.design.factory.abstractFactory.SpringMvcConfigAbstract;

/**
 * 工厂实现类
 * Created By zhangyufei on 2018/6/4
 */
public class SpringMvcModel extends SpringMvcConfigAbstract{

    @Override
    public String SpringMvcAdaptation() {
        System.out.println("model");
        return "model";
    }
}
