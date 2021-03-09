package com.holybell.algorithm.common.util;

import java.util.Arrays;

public abstract class ArrayUtil {

    public static void printBoard(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        // 换行
        System.out.println();
    }
}
