package org.ryan.chapter4;

public class SumByRecursive {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int sum = sumByRecursive(array);
        System.out.println("求和：" + sum);
        System.out.println("最大数：" + findMaxNum(array));
    }

    /**
     * 递归求和（数组）
     * @param list
     * @return
     */
    public static int sumByRecursive(int[] list) {
        /**
         * 递归求取数组的和是采用分而治之的思想，将问题的规模缩小使其符合基线条件
         *
         * D&C（分而治之）的工作原理：
         * （1）找出简单的基线条件
         * （2）确定如何缩小问题的规模，使其符合基线条件
         */
        if (list.length == 1) {//数组只有一个元素,基线条件
            return list[0];
        }else {//递归条件，只要数组中的元素大于1则递归调用自身
            int[] listDest = new int[list.length - 1];
            System.arraycopy(list,1,listDest,0,list.length - 1);
            return list[0] + sumByRecursive(listDest);
        }
    }

    /**
     * 递归找出数组中最大的数
     * @param list
     * @return
     */
    public static int findMaxNum(int[] list) {
        if (list.length == 1) {//数组只有一个元素,基线条件
            return list[0];
        }else {//递归条件，只要数组中的元素大于1则递归调用自身
            if (list[0] > list[1]) {
                list[1] = list[0];
            }
            int[] listDest = new int[list.length - 1];
            System.arraycopy(list,1,listDest,0,list.length - 1);
            return findMaxNum(listDest);
        }
    }
}
