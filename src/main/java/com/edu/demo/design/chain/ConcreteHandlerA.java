package com.edu.demo.design.chain;

/**
 * 责任链模式
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteHandlerA extends Handler{


    @Override
    public void handlerRequest(int request) {

        if(request >= 0 && request < 10){
            System.out.println("ConcreteHandlerA 处理请求");
        }else{
            successor.handlerRequest(request);
        }
    }

}
