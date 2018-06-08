package com.edu.demo.design.factoryMethod;

/**
 * 工厂方法模式 B场景工厂
 * Created By zhangyufei on 2018/6/8
 */
public class FactoryOperationB implements IFactory{

    @Override
    public Operation createOperation() {
        return new OperationB();
    }
}
