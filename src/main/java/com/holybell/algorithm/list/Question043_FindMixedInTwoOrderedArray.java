package com.holybell.algorithm.list;


import com.holybell.algorithm.sort.Question004_MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度：中等
 * <p>
 * 如何计算两个有序整型数组的交集
 * <p>
 * 假设两个含有n个元素的有序（非降序）整型数组a和b，其中a={0,1,2,3,4},b={1,3,5,7,9},那么它们的交集为{1,3}。
 * <p>
 * 如果不采用HashSet(BitSet)存储顺序遍历数组a，再判断是否在数组b的方法，有没有其他思路？
 */
public class Question043_FindMixedInTwoOrderedArray {

    /**
     * 从两个有序数组中查询重叠的元素
     *
     * @param a 有序数组1
     * @param b 有序数组2
     */
    private static Integer[] myMixed(int[] a, int[] b) {
        return null;
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
     * 从两个有序数组中查询重叠的元素
     *
     * 二路归并法，思路类似归并排序的左右子数组比较过程，两个数组元素两两比较，提取重复元素
     *
     * @see Question004_MergeSort
     *
     * @param a 有序数组1
     * @param b 有序数组2
     */
    private static Integer[] mixed(int[] a, int[] b) {

        // 以下情况就不需要处理了
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return null;
        }

        // 缓存两个数组重叠的元素
        List<Integer> resultList = new ArrayList<>();

        int indexA = 0, indexB = 0;
        // 只要一个数组比较全部元素，就可以不需要比较了
        while (indexA < a.length && indexB < b.length) {
            // 找到重复的元素
            if (a[indexA] == b[indexB]) {
                // 添加到结果集合中
                resultList.add(a[indexA]);
                // 两个数组的索引往后移动
                indexA++;
                indexB++;
            }
            // 当前比较的两个元素，数组A的更小，由于数组是升序的，那么只需要将数组A的往后移动继续与数组B比较
            else if (a[indexA] < b[indexB]) {
                indexA++;
            }
            // 当前比较的两个元素，数组B的更小，由于数组是升序的，那么只需要将数组B的往后移动继续与数组A比较
            else {
                indexB++;
            }
        }

        return resultList.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 4};
        int b[] = {1, 3, 5, 6, 7};
        System.out.println("正确答案:" + Arrays.toString(mixed(a, b)));
        System.out.println("-----------------------------------------");
        System.out.println("正确答案:" + Arrays.toString(myMixed(a, b)));
    }
}
