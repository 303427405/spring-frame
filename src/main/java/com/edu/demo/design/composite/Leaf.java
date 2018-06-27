package com.edu.demo.design.composite;

/**
 * 组合模式 叶节点
 * Created By zhangyufei on 2018/6/26
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("add a leaf");

    }

    @Override
    public void remove(Component component) {
        System.out.println("remove a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println("-"+name);
    }
}
