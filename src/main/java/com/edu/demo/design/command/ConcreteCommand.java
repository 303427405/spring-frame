package com.edu.demo.design.command;

/**
 * 命令模式 具体执行者
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteCommand extends Command{


    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
