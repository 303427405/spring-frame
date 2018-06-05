package com.edu.demo.design.strategy;

/**
 * Created By zhangyufei on 2018/6/5
 */
public class Context {

    Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }


    /**
     *上下文
     */
    public void ContextInterface(){
        strategy.AlgorithmInterface();
    }


    /**
     * 客户端执行方法
     */
    public static void main(String [] args){
        Context context = new Context(new ConcreteStrategyA());
        context.ContextInterface();
    }
}
