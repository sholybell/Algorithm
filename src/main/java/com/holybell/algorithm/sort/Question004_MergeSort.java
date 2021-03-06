package com.holybell.algorithm.sort;

import com.holybell.algorithm.common.Base;

import java.util.Arrays;

// 归并排序：
//
// 对于给定的一组记录（假定共有n个记录），首先将每两个相邻的长度为1的子序列进行归并，
// 得到n/2（向上取整）个长度为2或1的有序子序列，再将其两两归并，
// 反复执行此过程，直到得到一个有序序列。
public class Question004_MergeSort extends Base {

    /**
     * 对归并排序的左右子数组分别进行排序
     *
     * @param a     待排序数组
     * @param start 起始位置
     * @param mid   中间位置
     * @param end   结束位置
     */
    private static void myMerge(int a[], int start, int mid, int end) {


    }

    /**
     * 对指定数组进行归并排序算法
     *
     * @param a     待排序数组
     * @param start 起始位置
     * @param end   结束位置
     */
    private static void myMergeSort(int a[], int start, int end) {


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
     * 对归并排序的左右子数组分别进行排序
     *
     * @param a     待排序数组
     * @param start 起始位置
     * @param mid   中间位置
     * @param end   结束位置
     */
    private static void merge(int a[], int start, int mid, int end) {
        int llen = mid - start + 1;
        int rlen = end - mid;

        int[] left = new int[llen];
        int[] right = new int[rlen];

        // 填充左右两个子数组
        for (int i = 0; i < llen; i++) {
            left[i] = a[start + i];
        }
        for (int i = 0; i < rlen; i++) {
            right[i] = a[mid + 1 + i];
        }

        // 开始将左右两个子数组的元素互相比较替换到原数组
        int lpos = 0, rpos = 0;
        while (lpos < llen && rpos < rlen) {
            if (left[lpos] < right[rpos]) {
                a[start++] = left[lpos++];
            } else {
                a[start++] = right[rpos++];
            }
        }

        // 此时左右子数组要么两个都往原数组填充完毕，要么一个填充完毕，还剩下一个，将剩下的数组元素填充到原数组
        if (lpos < llen) {
            for (int i = lpos; i < llen; i++) {
                a[start++] = left[i];
            }
        }
        if (rpos < rlen) {
            for (int i = rpos; i < rlen; i++) {
                a[start++] = right[i];
            }
        }
    }


    /**
     * 对指定数组进行归并排序算法
     *
     * @param a     待排序数组
     * @param start 起始位置
     * @param end   结束位置
     */
    private static void mergeSort(int a[], int start, int end) {
        if (start < end) {
            int mid = (start + end) >>> 1;
            // 递归左右子数组
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            // 对左右子数组进行排序,会先对左右子数组只有一个元素的情况往上递归
            merge(a, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        int len = a.length;
        myMergeSort(a, 0, len - 1);
        System.out.println(Arrays.toString(a));
    }
}
