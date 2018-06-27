package com.edu.demo.design.mediator;

/**
 * 中介模式 具体同事对象
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteColleagueB extends Colleague{

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    public void send(String message){
        mediator.send(message,this);
    }

    public void notify(String message){
        System.out.println("同事2 得到的消息："+message);
    }
}
