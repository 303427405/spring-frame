package com.edu.demo.design.state;

/**
 * 状态模式 定义当前的状态
 * Created By zhangyufei on 2018/6/26
 */
public class Context {

    private State state;

    public Context(State state){
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前的状态："+state);
    }

    public void request(){
        state.handle(this);
    }


    public static void main(String[] args){
        Context context = new Context(new ConcreteStateA());

        context.request();
        context.request();
        context.request();
    }
}
