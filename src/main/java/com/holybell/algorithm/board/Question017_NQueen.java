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
        // 每行的row和col操作结果都会定位到同样一个撇、捺位置
        hills = new int[4 * n - 1];
        dales = new int[2 * n - 1];
        // 以上没有考虑横向，因为每次递归都是计算每行的可放位置，不需要一个存储行结果的数组

        queens = new int[n];

        // 从第0行开始递归求解
        backtrack(0);
        return output;
    }

    /**
     * 递归每一行求解当行可放置N皇后的位置
     *
     * @param row 计算N皇后解答的行
     */
    private static void backtrack(int row) {
        // 遍历当前行每一列的位置
        for (int col = 0; col < N; col++) {
            // 判断当前位置是否已经被前面行放过的N皇后辐射到
            if (isNotUnderAttack(row, col)) {
                // 当前位置没有被前面的N皇后辐射到，那么放置，并记录被当前N皇后辐射的位置
                placeQueen(row, col);
                // 如果当前行已经是最后一行，那么输出N皇后结果
                if (row + 1 == N)
                    addSolution();
                    // if not proceed to place the rest
                else
                    // 当前行不是最后一行，那么递归求解下一行的N皇后位置
                    backtrack(row + 1);
                // 本题难点！！！！！！！  回溯将每一行的当前放置结果都删除，尝试放置下一个位置，看看有没有其他的N皇后解答
                removeQueen(row, col);
            }
        }
    }

    /**
     * 判断当前棋盘位置有没有被其他N皇后辐射到
     */
    private static boolean isNotUnderAttack(int row, int col) {
        return cols[col] + hills[row - col + 2 * N] + dales[row + col] == 0;
    }

    /**
     * 放置N皇后，并且记录竖向、撇向、捺向的辐射情况
     */
    private static void placeQueen(int row, int col) {
        cols[col] = 1;
        queens[row] = col;
        // 撇方向统计占用情况
        hills[row - col + 2 * N] = 1; // "hill" diagonals
        dales[row + col] = 1; // "dale" diagonals
    }

    /**
     * 移除N皇后放置结果，从而可以回溯放置N皇后
     */
    private static void removeQueen(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        hills[row - col + 2 * N] = 0;
        dales[row + col] = 0;
    }

    /**
     * 将本次数独解答存储到全局变量中
     */
    private static void addSolution() {
        List<String> solution = new ArrayList<>();
        // 遍历每行的N皇后结果
        for (int row = 0; row < N; row++) {
            // queen[row]记录着每行N皇后所在列
            int col = queens[row];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++)
                sb.append(".");
            sb.append("Q");
            for (int j = 0; j < N - col - 1; j++)
                sb.append(".");
            //记录本行N皇后放置结果
            solution.add(sb.toString());
        }
        // 记录本次N皇后每行结果
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
