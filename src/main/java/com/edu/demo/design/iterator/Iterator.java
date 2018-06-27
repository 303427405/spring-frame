package com.edu.demo.design.iterator;

/**
 * 迭代器模式  迭代器抽象类
 * Created By zhangyufei on 2018/6/27
 */
public abstract class Iterator {

    public abstract Object isFirst();

    public abstract Object next();

    public abstract boolean isDone();

    public abstract Object currentItem();
}
