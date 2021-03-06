package org.ryan.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public static void main(String[] args) {
        Double[] dataArrays = {12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0
        };
        List<Double> list = Arrays.asList(dataArrays);
        long startTime = System.currentTimeMillis();
        list = quickSort(list);
        long endTime = System.currentTimeMillis();
        System.out.println("consume time: " + (endTime -  startTime));
//        list.stream().forEach(s -> System.out.println(s));
    }

    /**
     * 快速排序
     * @param list
     * @return
     */
    public static List<Double> quickSort(List<Double> list) {
        /**
         * 利用分而治之思想（递归）来实现快速排序
         */
        if (list.size() < 2) {//基线条件，如果集合中的元素只有1个就返回，否则进入递归中
            return list;
        }else {
            Double pivot = list.get(0);//获取基准线,将列表分为小于基准线的列表和大于基准线的列表
            List<Double> less = new ArrayList<>(list.size());
            List<Double> greater = new ArrayList<>(list.size());
            for (int i = 1; i < list.size(); i++) {
                Double num = list.get(i);
                if (num <= pivot) {
                    less.add(num);
                }else {
                    greater.add(num);
                }
            }
            List<Double> all = new ArrayList<>(list.size());
            all.addAll(quickSort(less));
            all.add(pivot);
            all.addAll(quickSort(greater));
            return all;
        }
    }
}
