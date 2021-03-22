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

    public static void printBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        // 换行
        System.out.println();
    }

    public static char[][] copyBoard(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        char[][] _board = new char[row][col];
        for (int i = 0; i < row; i++) {
            _board[i] = Arrays.copyOf(board[i], col);
        }
        return _board;
    }
}
