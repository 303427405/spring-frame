package com.edu.demo.design.command;

/**
 * 命令模式 要求执行方法
 * Created By zhangyufei on 2018/6/27
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }

    public static void main(String[] args){
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);

        Invoker invoker = new Invoker();

        invoker.setCommand(command);
        invoker.executeCommand();;
    }
}
