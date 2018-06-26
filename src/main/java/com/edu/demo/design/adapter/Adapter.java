package com.edu.demo.design.adapter;

/**
 * Created By zhangyufei on 2018/6/26
 */
public class Adapter  extends Target{

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {

        adaptee.specificRequest();
    }


    public static void main(String[] args){
        Target target = new Adapter();
        target.request();
    }
}
