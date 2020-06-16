package com.holybell.algorithm.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度：困难
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 链接：https://leetcode-cn.com/problems/n-queens
 */
public class Question017_NQueen {

    // 最终输出结果
    private static List<List<String>> output = new ArrayList<>();


    // 列，因为是采取一行行扫描求解，不需要一个行来记录占用情况
    private static int cols[];
    // 皇后撇方向的占用情况
    private static int hills[];
    // 皇后捺方向的占用情况
    private static int dales[];
    // N皇后
    private static int N;
    // 记录每个N皇后的摆放位置
    private static int queens[];

    /**
     * 求N皇后的解法
     *
     * @param n N皇后题目
     */
    private static List<List<String>> mySolveNQueens(int n) {

        return output;
    }

    private static void myBacktrack(int row) {

    }

    private static boolean myIsNotUnderAttack(int row, int col) {
        return false;
    }


    private static void myPlaceQueen(int row, int col) {

    }

    private static void myRemoveQueen(int row, int col) {

    }

    private static void myAddSolution() {

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
     * 求解N皇后
     */
    private static List<List<String>> solveNQueens(int n) {
        N = n;
        cols = new int[n];
        // 撇方向采取row-col计算由于会出现负数，因此下面操作的时候会加上2N，这里要大点
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }

    private static void backtrack(int row) {
        for (int col = 0; col < N; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                // if n queens are already placed
                if (row + 1 == N)
                    addSolution();
                    // if not proceed to place the rest
                else
                    backtrack(row + 1);
                // backtrack
                removeQueen(row, col);
            }
        }
    }

    private static boolean isNotUnderAttack(int row, int col) {
        return cols[col] + hills[row - col + 2 * N] + dales[row + col] == 0;
    }

    private static void placeQueen(int row, int col) {
        cols[col] = 1;
        queens[row] = col;
        // 撇方向统计占用情况
        hills[row - col + 2 * N] = 1; // "hill" diagonals
        dales[row + col] = 1; // "dale" diagonals
    }

    private static void removeQueen(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        hills[row - col + 2 * N] = 0;
        dales[row + col] = 0;
    }

    private static void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int row = 0; row < N; row++) { // 遍历每行的N皇后结果
            int col = queens[row]; // queen[row]记录着每行N皇后所在列
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++)
                sb.append(".");
            sb.append("Q");
            for (int j = 0; j < N - col - 1; j++)
                sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public static void main(String[] args) {
        List<List<String>> resultList = solveNQueens(4);
        for (List<String> list : resultList) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        System.out.println("--------------------->");
        // 重置正确答案的操作
        N = 0;
        cols = null;
        hills = null;
        dales = null;
        queens = null;
        output.clear();

        resultList = mySolveNQueens(4);
        for (List<String> list : resultList) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
