package com.edu.demo.design.strategy;

/**
 * 策略模式 具体实现类
 * Created By zhangyufei on 2018/6/5
 */
public class ConcreteStrategyA extends Strategy{


    @Override
    public void AlgorithmInterface() {
        System.out.println("算法A 实现");
    }
}
