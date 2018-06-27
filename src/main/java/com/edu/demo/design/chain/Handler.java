package com.edu.demo.design.chain;

/**
 * 责任链模式 定义一个处理请求的接口
 * Created By zhangyufei on 2018/6/27
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    public abstract void handlerRequest(int request);
}
