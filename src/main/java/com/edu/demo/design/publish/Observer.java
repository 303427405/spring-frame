package com.edu.demo.design.publish;

/**
 * 观察者模式 抽象观察者
 * Created By zhangyufei on 2018/6/20
 */
public abstract class Observer {

    /**为所有具体观察者定义一个接口 在得到主题时跟新自己状态*/
    public abstract void update();

}
