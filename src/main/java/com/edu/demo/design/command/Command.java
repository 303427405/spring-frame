package com.edu.demo.design.command;

/**
 * 命令模式 执行操作 抽象
 * Created By zhangyufei on 2018/6/27
 */
public abstract class Command {

    protected Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    abstract public void execute();
}
