package com.edu.demo.design.publish;

/**
 * 观察者模式 具体通知者
 * Created By zhangyufei on 2018/6/20
 */
public class ConcreteSubject extends Subject{

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
