package com.holybell.algorithm.list;

/**
 * 难度:中等
 * <p>
 * 递归求一个数组的最大值
 */
public class Question037_RecursiveFindMax {


    /**
     * 递归求一个数组的最大值
     *
     * @param a     给定数组
     * @param start 递归开始元素位置
     */
    private static int myMaxNum(int[] a, int start) {
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
     * 递归求一个数组的最大值
     *
     * @param a     给定数组
     * @param start 递归开始元素位置
     */
    private static int maxNum(int[] a, int start) {

        // 以下情况不处理
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }

        if (start == a.length - 1) {
            return a[start];
        } else {
            return Math.max(a[start], maxNum(a, start + 1));
        }

    }

    public static void main(String[] args) {
        int[] a = {0, 16, 2, 3, 4, 5, 10, 7, 8, 9};
        System.out.println("正确答案:" + maxNum(a, 0));
        System.out.println("本次答案:" + myMaxNum(a, 0));
    }
}