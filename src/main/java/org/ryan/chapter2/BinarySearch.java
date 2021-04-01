package org.ryan.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分查找
 * 二分查找适合于有序排列的数据，如果应用与无序数据则此算法达不到对应的性能，
 * 二分查找的时间复杂度为log2n
 */
public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,6,8,9,11,12,23,24,25,35,36,37,55,56,57,58,59,60,61,63);
        List<Integer> list1 = new ArrayList<Integer>(10000);
        for (int i = 0; i < 10000000; i++) {
            list1.add(i);
        }

        System.out.println("元素位置：" + binarySearch(list1,2588888));
    }

    /**
     * 二分查找
     * @param list      数据（集合）
     * @param toSearch  要查找的元素
     * @return
     */
    public static int binarySearch(List<Integer> list,int toSearch) {
        if (list.isEmpty()) {//如果数组是空的返回-1
            return -1;
        }
        if (list.size() == 1) {//如果数组只有一个元素,判断第一个元素与要查询的元素是否相等，相等返回0，否则返回-1
            if (new Integer(toSearch).equals(list.get(0))) {
                return 0;
            }else {
                return -1;
            }
        }
        //先定义集合的最低位low和最高位high
        int low = 0;
        int heigh = list.size() - 1;
        int mid = 0;
        int count = 0;//记录查询次数
        while (low <= heigh) {
            count ++;
            mid = (low + heigh) / 2;
            if (list.get(mid) > toSearch) {
                heigh = mid - 1;
            }else if (list.get(mid) < toSearch) {
                low = mid + 1;
            }else {
                System.out.println("二分查找binarySearch查询次数：" + count);
                return mid;
            }
        }
        System.out.println("二分查找binarySearch查询次数：" + count);
        return -1;
    }
}
