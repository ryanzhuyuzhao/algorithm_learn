package org.ryan.chapter3;

import java.util.ArrayList;
import java.util.List;

public class RecursiveFindKeyInBox {

    public static void main(String[] args) {
        /**寻找钥匙*/
        List<Component> boxList = new ArrayList<Component>();
        Box box1 = new Box();
        List<Component> subBoxList1 = new ArrayList<>();
        subBoxList1.add(new Box());
        subBoxList1.add(new Box());
        subBoxList1.add(new Key());
        box1.setSundries(subBoxList1);
        boxList.add(box1);
        boxList.add(new Box());
        boxList.add(new Box());
        boxList.add(new Box());
        lookForKey(boxList);

        /**阶乘调用*/
        System.out.println(factorial(5));

    }


    /**
     * 在一堆有嵌套的盒子中查找钥匙
     *
     * 递归程序最重要的就是要找到基线条件与递归条件
     * 寻找钥匙的基线条件当数据是钥匙是就停止递归，否则一直递归
     * @param boxList
     */
    public static void lookForKey(List<Component> boxList) {
        for (Component component : boxList) {
            if (component.isBox()) {
                Box box = (Box)component;
                //递归调用
                lookForKey(box.getSundries());
            }else if (!component.isBox()) {
                System.out.println("found the key: " + component);
                return;
            }
        }
    }

    /**
     * 秒表计时器
     * @param num
     */
    public static void countDown(int num) {
        System.out.println(num);
        if (num < 1) {
            return;
        }else {
            countDown(num - 1);
        }
    }

    /**
     * 阶乘
     * @param num
     * @return
     */
    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }else {
            return num * factorial(num - 1);
        }
    }
}
