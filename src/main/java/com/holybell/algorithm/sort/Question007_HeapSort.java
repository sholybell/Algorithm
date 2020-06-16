package com.holybell.algorithm.sort;

import com.holybell.algorithm.common.Base;

import java.util.Arrays;

/**
 * 堆排序：
 * <p>
 * 先将数组根据堆排序排好序，然后每次兑换头部和未被排序的尾部元素，
 * 之后重新调整堆排序，反复执行
 */
public class Question007_HeapSort extends Base {


    private static void myMinHeapSort(int a[]) {

    }

    private static void myAdjustMinHeap(int a[], int start, int end) {

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

    private static void minHeapSort(int a[]) {

        // 这是一个优化，即从二叉树的中间节点开始往后调整二叉树即可，不需要从0开始
        // 调整的规则：为从当前节点开始到最后一个节点进行最小堆调整，直到当前节点为0
        for (int i = a.length / 2; i >= 0; i--) {
            adjustMinHeap(a, i, a.length - 1);
        }

        // 当前堆中最小的元素在堆顶，和最后一个元素交换，重新根据最小堆原则调整0 ~ i-1之间的元素
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            adjustMinHeap(a, 0, i - 1);
        }
    }

    private static void adjustMinHeap(int a[], int start, int end) {

        if (a == null || a.length == 0) {
            return;
        }

        int parentPos = start;
        int parentValue = a[start];

        while (parentPos * 2 + 1 < end) {       // 下标从0开始，左子节点坐标为 parentPos * 2 + 1
            int childPos = parentPos * 2 + 1;   // childPos的赋值要写在while里面，否则如果仅仅满足第二个if，childPos的值就不会变动了，死循环
            if (childPos + 1 < end && a[childPos] > a[childPos + 1]) {  // 判断是否存在右子节点，同时右子节点小于左子节点，是的话取右子节点
                childPos++;
            }
            if (a[childPos] < parentValue) {        // 子节点的值小于父节点，父子节点交换
                a[parentPos] = a[childPos];
                parentPos = childPos;
            } else {
                break;
            }
        }
        a[parentPos] = parentValue; // 将原先父节点的值赋值给父节点最后移动到的下标
    }


    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 0, 1, 3, 2, 100, 6};
        myMinHeapSort(a);
        System.out.println(Arrays.toString(a));
    }

}