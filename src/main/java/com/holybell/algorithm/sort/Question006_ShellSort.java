package com.holybell.algorithm.sort;


import com.holybell.algorithm.common.Base;

import java.util.Arrays;

/**
 * 希尔排序：
 * <p>
 * 先将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少，
 * 然后对各个子序列分别进行直接插入排序，待整个待排序的序列"基本有序后"，
 * 最后再对所有元素进行一次直接插入排序。
 * <p>
 * 可以这么简单的理解，根据步长，将当前数组划分成多个子数组，每次循环的时候，各个子数组进行插入排序，
 * 步长越来越小，最后变成1的时候，其实就是一个纯正的选择排序了.....
 */
public class Question006_ShellSort extends Base {

    private static void myShellSort(int a[]) {

        if (a == null || a.length == 0) {
            return;
        }

        for (int step = a.length / 2; step > 0; step = step / 2) {                  // 比较的步长每次循环减少为一半
            for (int comparePos = step; comparePos < a.length; comparePos++) {      // 从步长的下标开始往后遍历，每个元素不断地按步长前进，和相应元素比较
                int beComparedPos = comparePos - step;                              // 求得第一个要被比较的步长前元素
                int comparedValue = a[comparePos];                                  // 当前元素的值，用来和前面的元素比较
                while (beComparedPos >= 0) {                                        // 一直比较到不能数组不能再往前
                    if (a[beComparedPos] > comparedValue) {                         // 如果步长前元素大于当前元素
                        a[beComparedPos + step] = a[beComparedPos];                 // 那么将步长前元素挪后一个步长
                        beComparedPos = beComparedPos - step;                       // 继续往前一个步长的元素比较
                    } else {                                                        // 比较到前面有步长距离元素小于等于当前元素，不再继续往前
                        break;
                    }
                }
                a[beComparedPos + step] = comparedValue;                            // 经过前面的比较，得到当前元素应该放的位置为comparedPos+step，无论前面操作是否有发生过元素变动
            }
        }
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

    private static void shellSort(int a[]) {

    }


    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        // int a[] = { 5, 4, 9, 8, 7, 6, 0, 1, 3, 2, 15, 14, 19, 18, 17, 16, 10, 11, 13,
        // 12 };
        // shellSort(a);
        myShellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
