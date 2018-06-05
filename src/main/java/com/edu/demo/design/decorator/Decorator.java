package com.edu.demo.design.decorator;

/**
 * 装饰模式   装饰抽象类 对component对扩展
 * Created By zhangyufei on 2018/6/5
 */
abstract class Decorator extends Component{

    protected Component component;

    public void setComponent(Component component){
        this.component = component;
    }

    /**
     * 重写 component的Operation方法
     */
    public void Operation(){
        if(component != null){
            component.Operation();
        }
    }
}
