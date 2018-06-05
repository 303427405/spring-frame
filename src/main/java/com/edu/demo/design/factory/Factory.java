package com.edu.demo.design.factory;

import com.edu.demo.design.factory.abstractFactory.SpringMvcConfigAbstract;

/**
 * 简单工厂模式  适配请求
 * Created By zhangyufei on 2018/6/4
 */
public class Factory {

    public static SpringMvcConfigAbstract createView(String adaptation){
        SpringMvcConfigAbstract springMvcConfigAbstract = null;

        switch (adaptation){
            case "model":
                springMvcConfigAbstract = new SpringMvcModel();
                break;
            case "string":
                springMvcConfigAbstract = new SpringMvcString();
                break;
            case "modelandView":
                springMvcConfigAbstract = new SpringMvcModelAndView();
                break;
        }
        return springMvcConfigAbstract;
    }


    public static void main(String [] args){
        String str = "string";
        SpringMvcConfigAbstract springMvcConfigAbstract = Factory.createView(str);
        springMvcConfigAbstract.SpringMvcAdaptation();
    }
}
