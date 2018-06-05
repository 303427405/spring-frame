package com.edu.demo.design.decorator;

/**
 * 装饰模式 具体装饰方法
 * Created By zhangyufei on 2018/6/5
 */
public class ConcreteComponentA extends Decorator{

    /**
     * 独有属性
     */
    private String addedState;

    public void Operation(){
        super.Operation();
        addedState = "帅气";
        System.out.println("ConcreteComponentA的装饰，独有属性："+addedState);
    }


}
