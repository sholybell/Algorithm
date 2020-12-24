package com.holybell.algorithm.dp;

/**
 * 难度:简单
 * <p>
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * <p>
 * 也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * 给定 N，计算 F(N)。
 * <p>
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * <p>
 * 示例 3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 * <p>
 * 提示:0 ≤ N ≤ 30
 **/
public class LeetCode509_fib {

    private static int _fib(int n) {
        return -1;
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
     * 题目很贴心的给出列递推公式，那么直接套用它使用递归算法就可以得到最简单的解法(暴力算法，性能不佳，会发现很多f(n)在递归的时候重复计算，但是可以将中间结果缓存)
     */
//    private static int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return fib(n - 1) + fib(n - 1);
//    }

    /**
     * 动态规划求解斐波那契数列,其实也是利用递推公式
     */
    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // 使用一个数组，记录每个数字的斐波那契数列和
        int[] dp = new int[n + 1];
        // 以下为已知斐波那契前两个数字的值，用于循环的开始
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("你的答案:");
        System.out.println(_fib(n));
        System.out.println("--------------------------->");
        System.out.println("正确答案:");
        System.out.println(fib(n));
    }
}
