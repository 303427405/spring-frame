package com.edu.demo.design.chain;

/**
 * 责任链模式
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteHandlerB extends Handler{


    @Override
    public void handlerRequest(int request) {

        if(request >= 10 ){
            System.out.println("ConcreteHandlerB 处理请求");
        }
    }

    public static void main(String[] args){
        Handler handler = new ConcreteHandlerA();
        Handler handler1 = new ConcreteHandlerB();

        handler.setSuccessor(handler1);

        handler.handlerRequest(20);

    }

}
