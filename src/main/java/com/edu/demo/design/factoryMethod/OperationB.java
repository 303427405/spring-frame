package com.edu.demo.design.factoryMethod;

/**
 * 工厂方法模式  抽象方法的具体实现
 * Created By zhangyufei on 2018/6/8
 */
public class OperationB  extends Operation{

    @Override
    public void result() {
        System.out.println("OperationB");

    }


    public static void main(String[] args){
        IFactory iFactory = new FactoryOperationA();
        Operation operation = iFactory.createOperation();
        operation.result();
    }
}
