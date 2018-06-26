package com.edu.demo.design.builder;

/**
 * 建筑者模式 指挥者类
 * Created By zhangyufei on 2018/6/19
 */
public class Director {

    public void construct(Builder builder){
        builder.builderPartA();
        builder.builderPartB();
    }

    public static void main(String [] args){

        Director director = new Director();
        Builder builder1 = new ConcreteBuilder1();
        Builder builder2 = new ConcreteBuilder2();

        director.construct(builder1);
        Product product = builder1.getResult();
        product.show();

        director.construct(builder2);
        Product product1 = builder2.getResult();
        product1.show();

    }
}
