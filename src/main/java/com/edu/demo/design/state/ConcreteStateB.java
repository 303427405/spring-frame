package com.edu.demo.design.state;

/**
 * 状态模式 具体状态
 * Created By zhangyufei on 2018/6/26
 */
public class ConcreteStateB extends State{

    @Override
    public void handle(Context context) {
        System.out.println("ConcreteStateB");
        context.setState(new ConcreteStateA());

    }
}
