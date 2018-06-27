package com.edu.demo.design.bridge;

/**
 * 桥接模式
 * Created By zhangyufei on 2018/6/27
 */
public class Abstraction {

    public Implementor implementor;

    public void setImplementor(Implementor implementor){
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}
