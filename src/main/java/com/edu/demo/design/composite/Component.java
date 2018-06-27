package com.edu.demo.design.composite;

/**
 * 组合模式 用于管理访问抽象类
 * Created By zhangyufei on 2018/6/26
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);
}


