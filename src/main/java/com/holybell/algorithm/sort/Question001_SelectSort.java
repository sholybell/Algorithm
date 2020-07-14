package com.holybell.algorithm.sort;

import com.holybell.algorithm.common.Base;

import java.util.Arrays;


// 选择排序:
//
// 对于给定的一组记录，经过一轮比较后得到最小的记录，然后将该记录与第一个记录的位置进行交换，
// 接着对不包括第一个记录以外的其他记录进行第二轮比较，得到最小的记录并与第二个记录进行位置交换；重复该过程，
// 直到进行比较的记录只有一个时为止
public class Question001_SelectSort extends Base {


    /**
     * 对数组进行选择排序
     *
     * @param a 给定数组
     */
    private static void mySelectSort(int a[]) {

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
     * 对数组进行选择排序
     *
     * @param a 给定数组
     */
    private static void selectSort(int[] a) {

        if (a == null || a.length == 0) {
            return;
        }

        int min = Integer.MAX_VALUE;
        int minPos = -1;

        for (int i = 0; i < a.length; i++) {
            min = a[i];
            minPos = i;

            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    minPos = j;
                }
            }

            if (i != minPos) {
                swap(a, i, minPos);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        mySelectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
