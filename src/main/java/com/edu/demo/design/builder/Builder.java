package com.edu.demo.design.builder;

/**
 * 建造者模式 抽象类
 * Created By zhangyufei on 2018/6/19
 */
public abstract class Builder {

    public abstract void builderPartA();

    public abstract void builderPartB();

    public abstract Product getResult();
}
