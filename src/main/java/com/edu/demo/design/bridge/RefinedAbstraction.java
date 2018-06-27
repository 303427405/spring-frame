package com.edu.demo.design.bridge;

/**
 * 桥接模式
 * Created By zhangyufei on 2018/6/27
 */
public class RefinedAbstraction extends Abstraction{

    @Override
    public void operation() {
        super.implementor.operation();
    }

    public static void main(String[] args){
        Abstraction abstraction = new Abstraction();

        abstraction.setImplementor(new ConcreteImplementorA());
        abstraction.operation();

        abstraction.setImplementor(new ConcreteImplementorB());
        abstraction.operation();
    }
}
