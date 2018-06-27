package com.edu.demo.design.mediator;

/**
 * 中介模式 抽象同事类
 * Created By zhangyufei on 2018/6/27
 */
public abstract class Colleague {


    protected Mediator mediator;


    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }


}
