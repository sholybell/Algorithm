package com.holybell.algorithm.recursive;


/**
 * 难度：中等
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * <p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * <p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * <p>
 * Related Topics 数学 二分查找
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/powx-n-by-leetcode/
 */
public class LeetCode50_Pow {
    /**
     * 快速幂算法（递归）
     * <p>
     * 可借助乘法结合律
     *
     * @param x 被操作数字
     * @param n 幂
     */
    private static double myPow(double x, int n) {
        return Double.MIN_VALUE;
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
     * 快速幂算法（递归）
     * <p>
     * 可借助乘法结合律
     *
     * @param x 被操作数字
     * @param n 幂
     */
    private static double pow(double x, int n) {

        // 注意幂可能是负数
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    /**
     * 借助乘法结合律递归操作
     * <p>
     * 两两结合相乘，递归向上操作
     *
     * @param x 被操作数字
     * @param n 幂 这里的n变为long类型，是因为可能n是-2147483648，但是转换为整型最大值最大为2147483647，整型越界，因此替换为long类型 ！！！！！！
     */
    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        // 终止条件一定要在调用递归方法之前 !!!!
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }


    public static void main(String[] args) {

        System.out.println("你的答案:");
        System.out.println("2的10次幂:" + myPow(2, 10));
        System.out.println("2.1的3次幂:" + myPow(2.1, 3));
        System.out.println("2的-5次幂:" + myPow(2, -5));
        System.out.println("2的-2147483648次幂:" + myPow(2, -2147483648));
        System.out.println("------------------------------------>");
        System.out.println("正确答案:");
        System.out.println("2的10次幂:" + pow(2, 10));
        System.out.println("2.1的3次幂:" + pow(2.1, 3));
        System.out.println("2的-5次幂:" + pow(2, -5));
        System.out.println("2的-2147483648次幂:" + pow(2, -2147483648));
    }
}