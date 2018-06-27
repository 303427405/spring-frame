package com.edu.demo.design.mediator;

/**
 * 中介者模式 抽象中介者类
 * Created By zhangyufei on 2018/6/27
 */
public abstract class Mediator {

    public abstract void send(String message , Colleague colleague);
}
