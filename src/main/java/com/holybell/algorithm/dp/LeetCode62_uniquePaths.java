package com.holybell.algorithm.dp;

/**
 * 难度:中等
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * <p>
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。   即表示每个点除非超出坐标，只能往下，往右两个方向移动
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * <p>
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * <p>
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * <p>
 * Related Topics 数组 动态规划
 */
public class LeetCode62_uniquePaths {

    private static int myUniquePaths(int m, int n) {
        return -1;
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
     * 递归解法   本解法leetcode超时
     */
    private static int uniquePathsV1(int m, int n) {
        return helper(0, 0, m, n);
    }

    private static int helper(int row, int col, int m, int n) {

        // 超出坐标返回0
        if (row >= m || col >= n) {
            return 0;
        }

        // 到达最后一个出口，返回可通过路径1
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        // 每个点位都是可以为往下走、往右走，即往下走和往右走的路线合计为当前点位总路线
        return helper(row + 1, col, m, n) + helper(row, col + 1, m, n);
    }

    // --------------------------------------------------------------------

    private static int uniquePathsV2(int m, int n) {

        int[][] paths = new int[m][n];

        // 最后一行的点位都只能往右走
        for (int i = 0; i < n; i++) {
            paths[m - 1][i] = 1;
        }

        // 最后一列的点位都只能往下走
        for (int i = 0; i < m; i++) {
            paths[i][n - 1] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                paths[row][col] = paths[row + 1][col] + paths[row][col + 1];
            }
        }

        return paths[0][0];
    }

    public static void main(String[] args) {
        System.out.println("你的答案:");
        System.out.println("[3,7]二维矩阵路径数量: " + myUniquePaths(3, 7));
        System.out.println("[7,3]二维矩阵路径数量: " + myUniquePaths(7, 3));
        System.out.println("------------------------------>");
        System.out.println("正确答案:");
        System.out.println("[3,7]二维矩阵路径数量: " + uniquePathsV1(3, 7));
        System.out.println("[7,3]二维矩阵路径数量: " + uniquePathsV2(7, 3));
    }

}

