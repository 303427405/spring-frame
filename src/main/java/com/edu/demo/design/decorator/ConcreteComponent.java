package com.edu.demo.design.decorator;

/**
 * 装饰模式 具体装饰的对象 起到给Component添加职责的功能
 * Created By zhangyufei on 2018/6/5
 */
public class ConcreteComponent extends Component{

    private String name;

    public ConcreteComponent() {
    }

    /**
     * 构造方法传参
     * @param name
     */
    public ConcreteComponent(String name) {
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.println("被装饰人："+name);
    }
}
