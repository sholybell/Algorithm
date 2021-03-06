package com.holybell.algorithm.dp.stock_market;

import java.util.Arrays;

/**
 * 难度: 中等
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * Related Topics 动态规划
 */
public class LeetCode309_maxProfitFreeze {

    private static int myMaxProfit(int[] prices) {
        return 0;
    }

    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------
    // --------------------------------------------------------------------

    private static int maxProfit(int[] prices) {

        int n = prices.length;

        if (n == 0 || n == 1) {
            return 0;
        }

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i == 1) {
                // TODO 第1天要和第0天买入以及自身买入的情况取较大值
                dp[1][1] = Math.max(dp[i - 1][1], -prices[1]);
            } else {
                // TODO 既然买入要等到卖出之后2天才能买，那么前一次未持有股票日为i-2
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] stocks = new int[]{1, 2, 3, 0, 2};
        System.out.println("你的答案:");
        System.out.println("数组 : " + Arrays.toString(stocks) + " 2次交易最大收益 : " + myMaxProfit(stocks));
        System.out.println("-------------------------->");
        System.out.println("正确答案:");
        System.out.println("数组 : " + Arrays.toString(stocks) + " 2次交易最大收益 : " + maxProfit(stocks));
    }
}
