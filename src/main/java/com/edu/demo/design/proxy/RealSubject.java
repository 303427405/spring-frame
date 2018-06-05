package com.edu.demo.design.proxy;

/**
 * 代理模式 真实请求
 * Created By zhangyufei on 2018/6/5
 */
public class RealSubject extends Subject{

    @Override
    public void Request() {
        System.out.println("真实的请求");

    }
}
