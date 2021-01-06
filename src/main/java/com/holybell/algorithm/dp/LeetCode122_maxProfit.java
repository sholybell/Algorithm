package com.holybell.algorithm.dp;

/**
 * 难度:简单
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释:
 * 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p>
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释:
 * 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p>
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释:
 * 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 提示：
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 */
public class LeetCode122_maxProfit {

    /**
     * 给定一个数组，数组每个元素表示某天股价，求给定一次买入卖出机会情况下，如何得到最大利润
     *
     * @param prices 股价数组
     */
    private static int _maxProfit(int[] prices) {
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

    /**
     * 给定一个数组，数组每个元素表示某天股价，求给定一次买入卖出机会情况下，如何得到最大利润
     * 联系{@link LeetCode121_maxProfit} 本题没有要求最大交易次数，121题要求只能交易一次
     *
     * @param prices 股价数组
     */
    private static int maxProfit(int[] prices) {
        // 数组非法，直接返回0
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 分析本题变量：
        // 1. 股票交易天数
        // 2. 最大交易次数（不限次数，不做考虑）
        // 3. 交易当日是否持有股票
        // 综合上述变量，整理出数组，第一维表示交易日，第二纬表示交易当日结束是否持有股票
        int[][] dp = new int[prices.length][2];

        // 分析最大利润状态的转变公式:
        // 交易当日未持有股票
        // dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i])
        // 要么前一个交易日未持有股票，要么前一个交易日持有股票，今日卖出，因此例如增加prices[i]
        //
        // 交易当日持有股票
        // dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i])
        // 要么前一个交易日持有股票，要么前一个交易日未持有股票，今日买入，因此例如减少prices[i] ----> 注意这里和121题不同，121题由于只能交易一次因此买入之前例如一定是0

        dp[0][0] = 0;           // 第一天为买入，利润0
        dp[0][1] = -prices[0];  // 第一天买入，利润为购买第一天股票的支出

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);    // 此处和121题不同
        }

        // 最有一定是未持有的时候利润大于有持有股票的利润
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        int[] stocks = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println("你的答案:" + _maxProfit(stocks));
        System.out.println("--------------------->");
        System.out.println("正确答案:" + maxProfit(stocks));
    }
}
