package com.edu.demo.design.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式 具体聚集实现类
 * Created By zhangyufei on 2018/6/27
 */
public class ConcreteAggregate extends Aggregate {

    private List<Object> items = new ArrayList<>();


    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int count(){
        return items.size();
    }


    public Object getIndexs(int indexs) {
        return items.get(indexs);
    }

    public void setIndexs(int indexs , Object tmp) {
        items.add(indexs,tmp);
    }

    public static void main(String[] args){
        ConcreteAggregate concreteAggregate = new ConcreteAggregate();

        concreteAggregate.setIndexs(0,"zhang");
        concreteAggregate.setIndexs(1,"xue");
        concreteAggregate.setIndexs(2,"liu");

        Iterator iterator = new ConcreteIterator(concreteAggregate);

        Object first = iterator.isFirst();
        System.out.println(iterator.isDone());
        while (iterator.isDone()){
            System.out.println("下一位："+iterator.currentItem());
            iterator.next();
        }
    }

}
