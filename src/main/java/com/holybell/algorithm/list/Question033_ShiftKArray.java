package com.holybell.algorithm.list;

import java.util.Arrays;

import static com.holybell.algorithm.common.Base.swap;

/**
 * 难度:中等
 * <p>
 * 将数组往右移动K位
 */
public class Question033_ShiftKArray {

    private static int[] myShiftK(int[] a, int k) {
        return null;
    }

    private static void myReverse(int[] a, int start, int end) {

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


    // 假设要把数组序列12345678右移2位，变为78123456，观察可以发现，78、123456顺序是不变的，可以把这两个看做两个整体，右移就是把这两个部分交换一下
    // 1.逆序数组子序列123456，变为654321 78
    // 2.逆序数组子序列78，变为654321 87
    // 3.全部逆序，数组序列变为78123456

    private static int[] shiftK(int[] a, int k) {

        // 以下情况不需要操作
        if (a == null || a.length == 0 || k <= 0) {
            return null;
        }

        // 避免k值长度大于数组长度
        k = k % a.length;

        int len = a.length;
        // 首先整个链表反转
        reverse(a, 0, len - 1);
        // 单独反转链表前部
        reverse(a, 0, k - 1);
        // 单独反转链表后部
        reverse(a, k, len - 1);

        return a;
    }

    /**
     * 反转指定范围内的数组成员
     *
     * @param a     目标数组
     * @param start 起始位置
     * @param end   终点位置
     */
    private static void reverse(int[] a, int start, int end) {
        while (end > start) {
            swap(a, start, end);
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("正确答案:" + Arrays.toString(shiftK(Arrays.copyOf(a, a.length), 10)));
        System.out.println("本次答案:" + Arrays.toString(myShiftK(Arrays.copyOf(a, a.length), 10)));
    }
}
