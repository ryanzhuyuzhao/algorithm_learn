package org.ryan.chapter8;

public class DynamicTest {

    //珠宝重量
    private static int[] ws = {2,3,5,5};
    //珠宝价值
    private static int[] vs = {2,4,3,7};

    public static void main(String[] args) {

    }

    public static int ks(int i,int j) {
        //初始化
        int[][] result = new int[i][j];
        for (int m = 0;m <= i;m++) {
            for (int n = 0;n <= j;n++) {
                result[m][n] = 0;
            }
        }
        for (int m = 0; m <= i;i++) {
            for (int n = 0; n <= j; n++) {
                if (n < ws[m]) {//无法装进去
                    result[m][n] = 0;
                }else {
                    if (m > 0) {

                    }
                }
            }
        }

        return 0;
    }


}
