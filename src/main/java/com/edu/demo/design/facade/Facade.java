package com.edu.demo.design.facade;

/**
 * 外观模式  外观类
 * Created By zhangyufei on 2018/6/19
 */
public class Facade {

    SubSystemOne subSystemOne;

    SubSystemTwo subSystemTwo;

    SubSystemThree subSystemThree;

    SubSystemFour subSystemFour;

    public Facade(){
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
        subSystemFour = new SubSystemFour();
    }

    public void methodA(){
        System.out.println("方法组A");
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
    }

    public void methodB(){
        System.out.println("方法组B");
        subSystemThree.methodTwo();
        subSystemFour.methodTwo();
    }

    public static void main(String[] args){
        Facade facade = new Facade();
        facade.methodA();


        facade.methodB();
    }

}
