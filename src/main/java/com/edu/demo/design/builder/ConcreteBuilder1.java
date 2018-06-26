package com.edu.demo.design.builder;

/**
 * 建造者模式 具体实现类
 * Created By zhangyufei on 2018/6/19
 */
public class ConcreteBuilder1 extends Builder{

    private Product product = new Product();

    @Override
    public void builderPartA() {
        product.add("部件A");
    }

    @Override
    public void builderPartB() {
        product.add("部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
