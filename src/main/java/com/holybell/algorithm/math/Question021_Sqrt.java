package com.holybell.algorithm.math;


/**
 * 难度：简单
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class Question021_Sqrt {

    /**
     * 求一个非负整数开根号
     * <p>
     * 注意点：
     * 1. 两个整数相乘可能导致超过int最大值
     * 2. 0也可以被开根号
     *
     * @param x 非负整数
     */
    private static int mySqrt(int x) {


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
     * 求一个非负整数开根号
     *
     * @param x 非负整数
     */
    private static int sqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == x / mid) { // 避免溢出
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        System.out.println("16平方根的值:" + sqrt(16));
        System.out.println("------------------>");
        System.out.println("16平方根的值:" + mySqrt(16));
    }
}