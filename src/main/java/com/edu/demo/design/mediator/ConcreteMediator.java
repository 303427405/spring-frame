package com.edu.demo.design.mediator;


/**
 * 中介模式 具体中介模式
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteMediator extends Mediator {

    private ConcreteColleagueA concreteColleagueA;
    private ConcreteColleagueB concreteColleagueB;


    @Override
    public void send(String message, Colleague colleague) {
        if(colleague == concreteColleagueA){
            concreteColleagueA.notify(message);
        }

        if(colleague == concreteColleagueB){
            concreteColleagueB.notify(message);
        }
    }


    public static void main(String[] args){
        ConcreteMediator concreteMediator = new ConcreteMediator();

        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(concreteMediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(concreteMediator);

        concreteMediator.concreteColleagueA = concreteColleagueA;
        concreteMediator.concreteColleagueB = concreteColleagueB;

        concreteColleagueA.send("你好");
        concreteColleagueB.send("哦");
    }
}
