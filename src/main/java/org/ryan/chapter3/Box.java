package org.ryan.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用组合模式定义盒子和钥匙的数据结构，盒子中包含钥匙，盒子和钥匙都实现其接口的isBox方法
 */
public class Box implements Component{

    private List<Component> sundries = new ArrayList<>();

    public Box() {
    }

    @Override
    public boolean isBox() {
        return true;
    }

    public List<Component> getSundries() {
        return sundries;
    }

    public void setSundries(List<Component> sundries) {
        this.sundries = sundries;
    }
}
