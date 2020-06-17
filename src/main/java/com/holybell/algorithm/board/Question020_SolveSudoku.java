package com.holybell.algorithm.board;


import com.holybell.algorithm.common.Base;

/**
 * 难度：困难
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 */
public class Question020_SolveSudoku extends Base {

    // 九宫格边长
    private static int n = 3;
    // 数独行长
    private static int N = n * n;

    private static int[][] rows = new int[N][N + 1]; // 第一纬度的矩阵从0开始，因此长度可以为N，第二维矩阵0下标是不用的，而9下标又需要用到，因此需要N+1的长度
    private static int[][] columns = new int[N][N + 1];
    private static int[][] boxes = new int[N][N + 1];

    // 保存最后的到的数独结果
    private static char[][] result_board;

    // 是否已经解完毕数独
    private static boolean sudokuSolved = false;


    /**
     * 解数独
     *
     * @param board 数独题目
     */
    private static void mySolveSudoku(char[][] board) {

    }

    /**
     * 将数字存入数独中
     *
     * @param d   数字
     * @param row 行
     * @param col 列
     */
    private static void myPlaceNumber(int d, int row, int col) {

    }


    /**
     * 回溯算法，每个位置都尝试1-9每个数字，当前可以就放置，如果不可以进行回溯前面的操作
     *
     * @param row 行
     * @param col 列
     */
    private static void myBacktrack(int row, int col) {

    }

    /**
     * 测试当前位置是否能够放置该数字
     *
     * @param d   数字
     * @param row 行
     * @param col 列
     */
    private static boolean myCouldPlace(int d, int row, int col) {
        return false;
    }

    /**
     * 当前位置放置这个数字，导致防止其他位置的时候没有答案，那么回溯进行数字移除
     *
     * @param d   数字
     * @param row 行
     * @param col 列
     */
    private static void myRemoveNumber(int d, int row, int col) {

    }

    /**
     * 放置下一个数字，其实就是方法递归的调用 backtrack
     *
     * @param row 行
     * @param col 列
     */
    private static void myPlaceNextNumbers(int row, int col) {

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
     * 解数独
     *
     * @param board 数独题目
     */
    private static void solveSudoku(char[][] board) {

        if (board == null) {
            return;
        }

        result_board = board;

        // 根据数独的题目，将题目中已经占据的数字存储到rows,columns,boxes中
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    /**
     * 将数字存入数独中
     *
     * @param d   数字
     * @param row 行
     * @param col 列
     */
    private static void placeNumber(int d, int row, int col) {

        int idx = (row / n) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        result_board[row][col] = (char) (d + '0');
    }

    /**
     * 回溯算法，每个位置都尝试1-9每个数字，当前可以就放置，如果不可以进行回溯前面的操作
     *
     * @param row 行
     * @param col 列
     */
    private static void backtrack(int row, int col) {

        // 当前的位置没有放置数字
        if (result_board[row][col] == '.') {
            // 数独能放的数字就是1-9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);

                    // 如果数独得到了解答，那么就不需要回溯，因为数独只有唯一解
                    if (!sudokuSolved)
                        removeNumber(d, row, col);
                }
            }
        } else {    // 当前位置已经放置数字，那么继续放置下一个位置的数字
            placeNextNumbers(row, col);
        }
    }

    /**
     * 测试当前位置是否能够放置该数字
     *
     * @param d   数字
     * @param row 行
     * @param col 列
     */
    private static boolean couldPlace(int d, int row, int col) {

        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    /**
     * 当前位置放置这个数字，导致防止其他位置的时候没有答案，那么回溯进行数字移除
     *
     * @param d   数字
     * @param row 行
     * @param col 列
     */
    private static void removeNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        result_board[row][col] = '.';
    }

    /**
     * 放置下一个数字，其实就是方法递归的调用 backtrack
     *
     * @param row 行
     * @param col 列
     */
    private static void placeNextNumbers(int row, int col) {
        // 如果行列都到达了最后一个位置，那么数独得到了解答
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        } else { // 数独没有得到解答，那么判断当前列是否到达最后一个位置，没有则递归下一列，否则递归下一行首个位置
            if (col == N - 1) {
                backtrack(row + 1, 0);
            } else {
                backtrack(row, col + 1);
            }
        }
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        // solveSudoku(board);
        // printSudu(Question07SS.board);

        System.out.println("------------->");

        sudokuSolved = false;
        result_board = new char[][]{};
        mySolveSudoku(board);
        printSudoku(result_board);
    }
}
