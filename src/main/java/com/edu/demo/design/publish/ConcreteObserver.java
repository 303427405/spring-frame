package com.edu.demo.design.publish;

/**
 * 观察者模式 具体观察者
 * Created By zhangyufei on 2018/6/20
 */
public class ConcreteObserver extends Observer{

    private String name;

    private String observerState;

    private ConcreteSubject concreteSubject;

    public ConcreteObserver() {
    }


    public ConcreteObserver(String name, ConcreteSubject concreteSubject) {
        this.name = name;
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {

        observerState = concreteSubject.getSubjectState();
        System.out.println("观察者的新状态："+observerState);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObserverState() {
        return observerState;
    }

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }

    public ConcreteSubject getConcreteSubject() {
        return concreteSubject;
    }

    public void setConcreteSubject(ConcreteSubject concreteSubject) {
        this.concreteSubject = concreteSubject;
    }


    public static void main(String[] args){
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("X",subject));

        subject.setSubjectState("ABC");
        subject.notity();
    }
}
