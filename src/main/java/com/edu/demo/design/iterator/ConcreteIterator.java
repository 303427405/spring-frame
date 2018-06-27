package com.edu.demo.design.iterator;

/**
 * 迭代器模式 具体实现类
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteIterator extends Iterator{


    private ConcreteAggregate concreteAggregate;

    private int current = 0;

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
    }

    @Override
    public Object isFirst() {
        return concreteAggregate.getIndexs(0);
    }

    @Override
    public Object next() {
        Object ret = null;
        current ++;
        if(current < concreteAggregate.count()){
            ret = concreteAggregate.getIndexs(current);
        }
        return ret;
    }

    @Override
    public boolean isDone() {
        System.out.println("concreteAggregate.count():"+concreteAggregate.count());
        return current >= concreteAggregate.count() ? false : true;
    }

    @Override
    public Object currentItem() {
        return concreteAggregate.getIndexs(current);
    }
}
