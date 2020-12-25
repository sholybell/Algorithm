package com.holybell.algorithm.list;


import com.holybell.algorithm.common.Base;

import java.util.Arrays;

/**
 * 难度：简单
 * <p>
 * 如何对数组两个有序子序段进行合并
 * <p>
 * 数组a[0,mid-1]和a[mid,n-1]是各自有序的，对数组a[0,n-1]的两个子有序段进行合并，得到a[0,n-1]整体有序，要求空间复杂度为O（1）（注：a[i]元素仅支持'<'运算符的）。
 * 假设给定数组a={1,5,6,7,9,2,4,8,10,13,14},mid=5，a[0]~a[4]是有序的，a[5]~a[10]是有序的，合并后的数组为{1,2,4,5,6,7,8,9,10,13,14}
 */
public class Question042_MergeTwoOrderArray extends Base {


    /**
     * 针对给定数组进行排序，数组根据mid分成两部分，两部分分别有序，整体无序，
     * 对其进行整体排序
     * <p>
     * 本题要求空间复杂度O(1)
     *
     * @param a   给定数组
     * @param mid 第二部分数组头元素下标
     */
    private static int[] mySort(int[] a, int mid) {

        return a;
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
     * 针对给定数组进行排序，数组根据mid分成两部分，两部分分别有序，整体无序，
     * 对其进行整体排序
     * <p>
     * 本题要求空间复杂度O(1)
     *
     * @param a   给定数组
     * @param mid 第二部分数组头元素下标
     */
    private static int[] sort(int[] a, int mid) {

        // 以下情况不处理
        if (a == null || a.length == 0 || mid < 0) {
            return null;
        }

        // 将第一部分的数组每个元素和后一部分数组的头元素比较，如果更大那就交换，然后重新排序后一部分的数组
        for (int i = 0; i < mid; i++) {
            // 前半部分有序数组的元素比第二部分数组的头元素更大
            if (a[i] > a[mid]) {
                swap(a, i, mid);
                adjustArray(a, mid);
            }
        }

        return a;
    }

    /**
     * 对数组进行排序
     *
     * @param a     需要排序的数组
     * @param start 数组开始排序的位置
     */
    private static void adjustArray(int[] a, int start) {

        // 采用冒泡排序的思路，相邻两两比较
        for (int i = start; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                swap(a, i, i + 1);
            } else {
                // 由于只需要确定一个元素的位置，一次比较没有比后面的元素大说明找到了位置，不需要再循环
                break;
            }
        }
    }

    // --------------------------------------------------------------------

    /**
     * 针对给定数组进行排序，数组根据mid分成两部分，两部分分别有序，整体无序，
     * 对其进行整体排序
     * <p>
     * 不！！要求空间复杂度O(1)
     * <p>
     * 参考归并排序 {@link com.holybell.algorithm.sort.Question004_MergeSort}
     *
     * @param a   给定数组
     * @param mid 第二部分数组头元素下标
     */
    private static int[] sort2(int[] a, int mid) {

        // 以下情况不处理
        if (a == null || a.length == 0 || mid < 0) {
            return null;
        }

        int[] left = new int[mid];
        int[] right = new int[a.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for (int i = 0; i < a.length - mid; i++) {
            right[i] = a[mid + i];
        }

        int lpos = 0, rpos = 0, start = 0;
        // 比较两个子数组的元素，按大小添加回原来的数组
        while (lpos < left.length && rpos < right.length) {
            if (left[lpos] < right[rpos]) {
                a[start++] = left[lpos++];
            } else {
                a[start++] = right[rpos++];
            }
        }

        // 处理前面剩下没有放置会原数组的元素
        if (lpos < left.length) {
            for (int i = lpos; i < left.length; i++) {
                a[start++] = left[i];
            }
        }

        // 处理前面剩下没有放置会原数组的元素
        if (rpos < right.length) {
            for (int i = rpos; i < right.length; i++) {
                a[start++] = right[i];
            }
        }
        return a;
    }


    public static void main(String[] args) {
        int a[] = {1, 5, 6, 7, 9, 2, 4, 8, 10, 13, 14};
        System.out.println("正确答案:" + Arrays.toString(sort(a, 5)));
        int b[] = {1, 5, 6, 7, 9, 2, 4, 8, 10, 13, 14};
        System.out.println("正确答案:" + Arrays.toString(sort2(b, 5)));
        System.out.println("---------------------------------------------->");
        int c[] = {1, 5, 6, 7, 9, 2, 4, 8, 10, 13, 14};
        System.out.println("正确答案:" + Arrays.toString(mySort(c, 5)));
    }
}