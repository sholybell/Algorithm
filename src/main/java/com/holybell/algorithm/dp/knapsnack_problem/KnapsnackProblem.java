package com.holybell.algorithm.dp.knapsnack_problem;

/**
 * 背包问题模板
 * <p>
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。其中第i个物品的重量为wt[i]，价值为val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * <p>
 * 举个简单的例子，输入如下：
 * <p>
 * N=3,W=4
 * wt=[2,1,3]
 * val=[4,2,3]
 * 算法返回 6，选择前两件物品装进背包，总重量 3 小于W，可以获得最大价值 6。
 * <p>
 * 相关题目：
 * {@link LeetCode322_coinChange}  硬币兑换
 */
public class KnapsnackProblem {

    /**
     * 背包问题
     *
     * @param W   背包最大能够装的重量
     * @param N   提供的物品数量
     * @param wt  物品的重量集合
     * @param val 物品的价值集合
     */
    private static int knapsnack(int W, int N, int[] wt, int[] val) {

        int[][] dp = new int[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                // 这里 i-1就表示当前物品的重量，由于dp[0][0] 表示的是0个物品，0重量，而wt数组从0开始，因此i-1表示当前物品
                if (w - wt[i - 1] < 0) {
                    //当前背包容量装不下，只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    //装入或者不装入背包，择优
                    // TODO 从前一个选择了物品的结果+当前物品价值  和  不选择当前物品 从上一个重量的价值 选一个更大的
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }

        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        knapsnack(4, wt.length, wt, val);
    }
}
