package com.holybell.algorithm.backtrack;

import com.holybell.algorithm.common.util.ArrayUtil;

/**
 * 难度:中等
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * Related Topics 数组 回溯算法
 */
public class LeetCode79_exist {

    private static boolean myExist(char[][] board, String word) {
        return false;
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

    private static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //  从二维数组上的每一个点开始进行深度遍历
                boolean result = helper(i, j, board, word, visited, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(int row, int col, char[][] board, String word, boolean[][] visited, int pos) {

        // pos从0开始，一旦发现pos等于字符串的长度，那么就说明前面的字符都和字符串相同，表示求得解答
        if (pos == word.length()) {
            return true;
        }

        // 发现下标异常，或者当前节点已经在本本节点DFS过程中遍历过，或者当前字符与字符串需要比较的字符不一致
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(pos)) {
            return false;
        }

        // 标记当前位置已经被使用
        visited[row][col] = true;

        boolean result1 = helper(row + 1, col, board, word, visited, pos + 1);
        boolean result2 = helper(row - 1, col, board, word, visited, pos + 1);
        boolean result3 = helper(row, col - 1, board, word, visited, pos + 1);
        boolean result4 = helper(row, col + 1, board, word, visited, pos + 1);
        if (result1 || result2 || result3 || result4) {
            return true;
        }

        // 重置当前节点，使得从另一个节点开始进行深度遍历的时候，可以重用该点
        visited[row][col] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board2 = new char[][]{
                {'a'}
        };
        char[][] board3 = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };

        System.out.println("二维网格1:");
        ArrayUtil.printBoard(board1);
        System.out.println();
        System.out.println("二维网格2:");
        ArrayUtil.printBoard(board2);
        System.out.println();
        System.out.println("二维网格3:");
        ArrayUtil.printBoard(board3);

        System.out.println("你的解答:");
        System.out.println("二维网格1 是否存在单词 ABCCED :" + myExist(board1, "ABCCED"));
        System.out.println("二维网格1 是否存在单词 ABCB   :" + myExist(board1, "ABCB"));
        System.out.println("二维网格2 是否存在单词 a      :" + myExist(board2, "a"));
        System.out.println("二维网格3 是否存在单词 AAB    :" + myExist(board3, "AAB"));

        System.out.println("------------------------------>");

        System.out.println("正确解答:");
        System.out.println("二维网格1 是否存在单词 ABCCED :" + exist(board1, "ABCCED"));
        System.out.println("二维网格1 是否存在单词 ABCB   :" + exist(board1, "ABCB"));
        System.out.println("二维网格2 是否存在单词 a      :" + exist(board2, "a"));
        System.out.println("二维网格3 是否存在单词 AAB    :" + exist(board3, "AAB"));
    }
}
