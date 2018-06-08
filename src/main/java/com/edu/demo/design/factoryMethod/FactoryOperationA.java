package com.edu.demo.design.factoryMethod;

/**
 * 工厂方法模式 A场景工厂
 * Created By zhangyufei on 2018/6/8
 */
public class FactoryOperationA implements IFactory{

    @Override
    public Operation createOperation() {
        return new OperationA();
    }
}
