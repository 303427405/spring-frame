package com.edu.demo.design.singleton;

/**
 * 单例模式
 * Created By zhangyufei on 2018/6/27
 */
public class Singleton {

    public static Singleton instance;

    public Singleton() {

    }

    public static Singleton getInstance(){
        if(instance == null){
            return new Singleton();
        }
        return instance;
    }
}
