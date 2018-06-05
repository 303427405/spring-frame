package com.edu.demo.design.decorator;

/**
 * 装饰模式 具体装饰方法
 * Created By zhangyufei on 2018/6/5
 */
public class ConcreteComponentB extends Decorator{


    public void Operation(){
        super.Operation();
        AddedBeHavior();
    }

    public void AddedBeHavior(){
        System.out.println("ConcreteComponentB 独有方法。聪明");
    }


    /**
     * 客户端方法
     */
    public static void main(String[] args){
        /**装饰对象*/
        ConcreteComponent concreteComponent = new ConcreteComponent("zyf");
        /**装饰对象 新加特性*/
        ConcreteComponentA concreteComponentA = new ConcreteComponentA();
        ConcreteComponentB concreteComponentB = new ConcreteComponentB();

        concreteComponentA.setComponent(concreteComponent);
        concreteComponentB.setComponent(concreteComponentA);
        concreteComponentB.Operation();
    }

}
