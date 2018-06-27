package com.edu.demo.design.bridge;

/**
 * 桥接模式 派生类
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteImplementorB extends Implementor{

    @Override
    public void operation() {
        System.out.println("ConcreteImplementorB");
    }
}
