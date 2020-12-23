package com.holybell.algorithm.board;

import java.util.*;

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
public class LeetCode51_NQueen {

    private static List<List<String>> _solveNQueens(int n) {
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

    private static List<List<String>> solveNQueens(int n) {
        // 存放最终结果
        List<List<String>> result = new ArrayList<>();
        // 记录每一次结果皇后的位置，下标为行，值为列，赋予初始值-1表示无解
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 以下三个集合分别存储列、两个对角线是否会被攻击到（不需要考虑行，行是本回溯算法每次回溯的依据，如果列和对角线不符合条件，行不会有结果）
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        // 开始进行回溯运算
        backtrack(result, queens, n, 0, columns, diagonals1, diagonals2);
        return result;
    }

    /**
     * 回溯N皇后的所有可能解
     *
     * @param result     存放最终结果的集合
     * @param queens     标记一次N皇后解答的N皇后摆放位置
     * @param n          N皇后的值
     * @param row        当前处理的行
     * @param columns    表示列被占据的集合
     * @param diagonals1 表示对角线被占据的集合
     * @param diagonals2 表示对角线被占据的集合
     */
    private static void backtrack(List<List<String>> result, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (columns.size() == n) {
            result.add(genSingleResult(queens, n));
        } else {
            // N皇后问题其实是放在一个正方形棋盘，通过循环判断在当前行应该放在哪一列
            for (int i = 0; i < n; i++) {
                // 判断该列是否被其他行占据
                if (columns.contains(i)) {
                    continue;
                }
                // 判断对角线1是否被其他行占据
                int diag1 = row - i;
                if (diagonals1.contains(diag1)) {
                    continue;
                }
                // 判断对角线2是否被其他行占据
                int diag2 = row + i;
                if (diagonals2.contains(diag2)) {
                    continue;
                }
                // 以上判断都通过，说明当前行当前列是可以放置N皇后的，标记占据状态
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diag1);
                diagonals2.add(diag2);
                // 开始计算下一行的可能性
                backtrack(result, queens, n, row + 1, columns, diagonals1, diagonals2);
                // 回溯算法本质，清除上面的占据状态
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diag1);
                diagonals2.remove(diag2);
            }
        }
    }

    /**
     * 换算一次回溯算法得到的结果
     *
     * @param queens N皇后的摆放数组结果
     * @param n      N皇后
     * @return N皇后的摆放List结果
     */
    private static List<String> genSingleResult(int[] queens, int n) {
        List<String> singleRes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            // 设置当前行的N皇后位置，queens下标为行，值为列
            row[queens[i]] = 'Q';
            singleRes.add(new String(row));
        }
        return singleRes;
    }

    public static void main(String[] args) {
        System.out.println("你的解答:");
        List<List<String>> resultList = Optional.ofNullable(_solveNQueens(4)).orElse(new ArrayList<>());
        for (List<String> list : resultList) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println("--------------------->");
        System.out.println("正确解答:");
        resultList = solveNQueens(4);
        for (List<String> list : resultList) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

}
