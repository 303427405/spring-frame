package com.edu.demo.design.clone;

/**
 * 原型模式  抽象类
 * Created By zhangyufei on 2018/6/8
 */
public abstract class ICloneable {

    public abstract void setPersonalInfo(String sex , String age);

    public abstract void setWorkExperience(String timeArea , String company);

    public abstract void showMsg();
}
