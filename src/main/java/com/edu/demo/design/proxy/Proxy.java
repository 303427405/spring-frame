package com.edu.demo.design.proxy;

/**
 * 代理模式 保存一个应用使代理可以访问实体
 * Created By zhangyufei on 2018/6/5
 */
public class Proxy extends Subject{


    RealSubject realSubject;

    @Override
    public void Request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        System.out.println("代理");
        realSubject.Request();
    }

    public static void main(String[] args){
        Proxy proxy = new Proxy();
        proxy.Request();;
    }
}
