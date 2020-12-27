package com.holybell.algorithm.common;

import java.util.Arrays;

public class Base {

    /**
     * 交换数组中两个位置的元素
     *
     * @param a 给定数组
     * @param i 位置1
     * @param j 位置2
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(ListNode head) {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public static void printSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }
}
