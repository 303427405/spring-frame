package com.edu.demo.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式 支节点
 * Created By zhangyufei on 2018/6/26
 */
public class Composite extends Component{

    private List<Component> childrens = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        childrens.add(component);
    }

    @Override
    public void remove(Component component) {
        childrens.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println("-"+name);

        for (Component component1 : childrens){
            component1.display(depth+2);
        }

    }
}
