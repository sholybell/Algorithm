package com.holybell.algorithm.union_find;

import com.holybell.algorithm.common.util.ArrayUtil;

/**
 * 难度:中等
 * <p>
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。
 * 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而isConnected[i][j] = 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 * <p>
 * <p>
 * 示例 1：
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * <p>
 * 示例 2：
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * <p>
 * Related Topics 深度优先搜索 并查集
 */
public class LeetCode547_findCircleNum {

    /**
     * 给定一个矩阵，判断是存在几个省份，省份的确立为，从一个城市出发，可以经过其他城市到达，
     * 所有城市都无法到达的城市，独立成为一个省份
     */
    private static int myFindCircleNum(int[][] isConnected) {
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
     * 这一定是一个正方形矩阵，长宽就是城市数量
     */
    private static int findCircleNumV1(int[][] isConnected) {
        int m = isConnected.length;             // 所有城市数量
        boolean[] visited = new boolean[m];     // 记录每个已经被DFS过的城市
        int provinces = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {                  // 该城市并未通过其他城市到达过
                dfs(isConnected, visited, m, i);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int citys, int i) {
        for (int j = 0; j < citys; j++) {       // 从当前城市出发，看看能否走到其他任何一个城市，若可以，这些城市之间构成一个省份
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, citys, j);
            }
        }
    }

    // --------------------------------------------------------------------

    /**
     * 并查集解法
     *
     * 与{@link LeetCode200_numIslands} 比对，本题的点位有实际意义，横竖轴每一个点位都表示同一个城市，无须上下左右4个方向扩散遍历
     */
    private static int findCircleNumV2(int[][] isConnected) {
        int citys = isConnected.length;

        UnionFind uf = new UnionFind(isConnected);

        for (int i = 0; i < citys; i++) {
            for (int j = 0; j < citys; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    static class UnionFind {

        private int[] roots;
        private int count = 0;

        /**
         * 与{@link LeetCode200_numIslands} 比对
         */
        public UnionFind(int[][] isConnected) {
            int citys = isConnected.length;
            roots = new int[citys];
            for (int i = 0; i < citys; i++) {
                roots[i] = i;
                count++;
            }

        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);

            if (xRoot != yRoot) {
                roots[xRoot] = yRoot;
                count--;
            }
        }

        private int find(int x) {
            int root = x;
            while (roots[root] != root) {
                root = roots[root];
            }

            while (root != x) {
                int tmp = roots[x];
                roots[x] = root;
                x = tmp;
            }
            return root;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int[][] grid2 = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };

        System.out.println("二维网格1:");
        ArrayUtil.printBoard(grid1);
        System.out.println("二维网格2:");
        ArrayUtil.printBoard(grid2);


        System.out.println("你的答案:");
        System.out.println("二维网格1省份 : " + myFindCircleNum(grid1));
        System.out.println("二维网格2省份 : " + myFindCircleNum(grid2));
        System.out.println("----------------------------->");
        System.out.println("正确答案:");
        System.out.println("二维网格1省份 : " + findCircleNumV1(grid1));
        System.out.println("二维网格2省份 : " + findCircleNumV2(grid2));
    }
}
