package org.ryan.chapter9;

/**
 * @ClassName DynamicAlgorithm
 * @Description
 * @Author Administrator
 * @Date 2021/4/12 0012 22:41
 * @wersion 1.0
 */
public class DynamicAlgorithm {
    /**物品价值*/
    private static int[] value = {0,1500,3000,2000};
    /**物品重量*/
    private static int[] weight = {0,1,4,3};

    public static void main(String[] args) {
        int num = stole(4,3,weight,value);
        System.out.println(num);
    }

    /**
     * @Author Ryan
     * 动态规划实现小偷偷东西最大价值
     * @Date 7:34 2021/4/13 0013
     * @Param [w, m, weight, value]
     * @return int
     */
    public static int stole(int w, int m,int[] weight,int[] value) {
        int[][] mw = new int[m + 1][w + 1];
        for (int i = 0; i < m + 1; i++) {
            mw[i][0] = 0;
        }
        for (int i = 0; i < w + 1; i++) {
            mw[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (j >= weight[i]) {
                    mw[i][j] = Math.max(mw[i - 1][j],mw[i - 1][j - weight[i]] + value[i]);
                }else {
                    mw[i][j] = mw[i - 1][j];
                }
            }
        }
        return mw[m][w];
    }

}
