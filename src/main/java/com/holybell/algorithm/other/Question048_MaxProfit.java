package com.holybell.algorithm.other;


/**
 * 难度:简单 (本题使用贪心算法，不一定是最优解)
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class Question048_MaxProfit {

    /**
     * 从给定数组中计算股市交易最大利润
     *
     * @param a 给定数组
     */
    private static int myMaxProfit(int[] a) {

        return Integer.MIN_VALUE;
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
     * 从给定数组中计算股市交易最大利润
     *
     * @param a 给定数组
     */
    private static int maxProfit(int[] a) {

        // 以下情况不处理
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }

        // 使用贪心算法，开启上帝视角，即本来股市交易并不知道第二天涨跌，但是贪心算法中要明确第二天的涨跌情况
        int profit = 0;
        for (int i = 1; i < a.length; i++) {
            // 只要知道第二天的价格超过前一天，那么默认前一天买入，今天卖出，此为上帝视角的体现
            if (a[i] > a[i - 1]) {
                profit += (a[i] - a[i - 1]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        int[] nums3 = new int[]{7, 6, 4, 3, 1};
        System.out.println("正确答案:" + maxProfit(nums1));
        System.out.println("正确答案:" + maxProfit(nums2));
        System.out.println("正确答案:" + maxProfit(nums3));
        System.out.println("---------------------------->");
        System.out.println("本次答案:" + myMaxProfit(nums1));
        System.out.println("本次答案:" + myMaxProfit(nums2));
        System.out.println("本次答案:" + myMaxProfit(nums3));
    }
}
