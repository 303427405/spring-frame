package com.edu.demo.design.publish;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式  主题或者抽象通知者
 * Created By zhangyufei on 2018/6/20
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    //增加观察者
    public void attach(Observer observer){
        observers.add(observer);
    }


    //移除观察者
    public void detach(Observer observer){
        observers.remove(observer);
    }

    //通知
    public void notity(){
        for (Observer observer : observers){
            observer.update();
        }
    }
}
