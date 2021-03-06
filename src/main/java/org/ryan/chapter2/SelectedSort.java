package org.ryan.chapter2;

import java.util.Arrays;
import java.util.List;

public class SelectedSort {

    public static void main(String[] args) {
        Double[] dataArrays = {12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0,
                12.4,1.0,23.2,34.0,5.0,22.0,12.0,12.0,234.0,435.0,123.0,123.0,34.0,54.0,12.0,54.0,21.0,43255.0,65.0,32.0,54964.0
        };
        List<Double> list = Arrays.asList(dataArrays);
        selectedSort(list);
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        selectedSort(list);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        System.out.println("consume time: " + (endTime -  startTime));
        list.stream().forEach(data -> {
            System.out.print(data + "\t");
        });
    }

    /**
     * 选择排序
     * @param list
     * @return
     */
    public static List<Double> selectedSort(List<Double> list) {
        /**
         * 选择排序，在数据中例如：4,23.3,43.2,2,45,231,434
         * （1）遍历所有数据找出最下的数据2将其放入第一个元素
         * （2）在剩下的数据中找出最小的数据将其放入第二个元素
         * （3）以此类推直到将所有的元素都排序完成
         * 选择排序是一种比较慢速的排序，其时间复杂度为O(n2)
         */
        if (list.isEmpty()) {//如果集合是空返回null
            return null;
        }
        if (list.size() == 1) {//如果集合只有一个元素返回原数据即可
            return list;
        }
        Double max = 0.0;//记录最大值
        Double temp = 0.0;//存储临时交换的值
        for (int i = 0; i < list.size(); i++) {
            max = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (max < list.get(j)) {
                    temp = max;
                    max = list.get(j);
                    list.set(j,temp);
                    list.set(i,max);
                }
            }
        }
        return list;
    }
}
