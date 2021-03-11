package com.holybell.algorithm.dp;

import com.holybell.algorithm.common.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度:中等
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * <p>
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * <p>
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * <p>
 * Related Topics 数组 动态规划
 */
public class LeetCode63_uniquePathsWithObstacles {

    private static int myUniquePathsWithObstacles(int[][] obstacleGrid) {
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

    private static int uniquePathsWithObstaclesV1(int[][] obstacleGrid) {

        int row = obstacleGrid.length, col = obstacleGrid[0].length;

        //  出口有障碍物，答案为0
        if (obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }

        int[][] cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cache[i][j] = -1;
            }
        }

        return helper(0, 0, row, col, obstacleGrid, cache);
    }

    private static int helper(int row, int col, int maxRow, int maxCol, int[][] obstacleGrid, int[][] cache) {

        if (row >= maxRow || col >= maxCol) {
            return 0;
        }

        if (cache[row][col] != -1) {
            return cache[row][col];
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (row + 1 == maxRow && col + 1 == maxCol) {
            return 1;
        }

        int count = helper(row + 1, col, maxRow, maxCol, obstacleGrid, cache) + helper(row, col + 1, maxRow, maxCol, obstacleGrid, cache);
        cache[row][col] = count;
        return count;
    }

    // --------------------------------------------------------------------

    private static int uniquePathsWithObstaclesV2(int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // TODO 如果出口有障碍物，无解
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] paths = new int[m][n];

        paths[m - 1][n - 1] = 1;

        // 最后一行的点位都只能往右走
        // TODO 最后一行一列应该从后往前推算每一个点位是后一个点位的值
        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                paths[m - 1][i] = 0;
            } else {
                paths[m - 1][i] = paths[m - 1][i + 1];
            }
        }

        // 最后一列的点位都只能往下走
        for (int i = m - 2; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                paths[i][n - 1] = 0;
            } else {
                paths[i][n - 1] = paths[i + 1][n - 1];
            }
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                if (obstacleGrid[row][col] == 1) {
                    paths[row][col] = 0;
                } else {
                    paths[row][col] = paths[row + 1][col] + paths[row][col + 1];
                }
            }
        }

        return paths[0][0];
    }

    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0},
                {0, 1}
        };
        int[][] board2 = new int[][]{
                {0, 0},
                {1, 1},
                {0, 0}
        };
        int[][] board3 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] board4 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0}
        };

        System.out.println("二维矩阵1:");
        ArrayUtil.printBoard(board1);
        System.out.println("二维矩阵2:");
        ArrayUtil.printBoard(board2);
        System.out.println("二维矩阵3:");
        ArrayUtil.printBoard(board3);
        System.out.println("二维矩阵4:");
        ArrayUtil.printBoard(board4);

        System.out.println("你的答案:");
        System.out.println("二维矩阵1总路径数:" + myUniquePathsWithObstacles(board1));
        System.out.println("二维矩阵2总路径数:" + myUniquePathsWithObstacles(board2));
        System.out.println("二维矩阵3总路径数:" + myUniquePathsWithObstacles(board3));
        System.out.println("二维矩阵4总路径数:" + myUniquePathsWithObstacles(board4));
        System.out.println("-------------------------->");
        System.out.println("正确答案:");
        System.out.println("二维矩阵1总路径数:" + uniquePathsWithObstaclesV2(board1));
        System.out.println("二维矩阵2总路径数:" + uniquePathsWithObstaclesV2(board2));
        System.out.println("二维矩阵3总路径数:" + uniquePathsWithObstaclesV2(board3));
        System.out.println("二维矩阵4总路径数:" + uniquePathsWithObstaclesV2(board4));
    }
}
