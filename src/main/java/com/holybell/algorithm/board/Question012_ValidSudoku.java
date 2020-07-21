package com.holybell.algorithm.board;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度：中等
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。
 * <p>
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/valid-sudokuF
 */
public class Question012_ValidSudoku {

    /**
     * 思路：根据数独的要求，只需要判断同一个数字，在横向、纵向、九宫格内是否出现超过1次即可
     *
     * @param board 数独
     */
    private static boolean myIsValidSudoku(char[][] board) {
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

    private static boolean isValidSudoku(char[][] board) {
        // 使用三个MAP保存横、竖、九宫格中数字和其出现的次数
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] cols = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];

        // 初始化上面创建好的Map
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>(9);
            cols[i] = new HashMap<>(9);
            boxes[i] = new HashMap<>(9);
        }

        // 遍历数独上面的每个点
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    // 数独点上的数字
                    int num = Character.getNumericValue(board[row][col]);
                    // 位于那个九宫格
                    int idx = (row / 3) * 3 + col / 3;

                    // 将当前数字在横、竖、九宫格几个Map中累计出现次数
                    rows[row].put(num, rows[row].getOrDefault(num, 0) + 1);
                    cols[col].put(num, cols[col].getOrDefault(num, 0) + 1);
                    boxes[idx].put(num, boxes[idx].getOrDefault(num, 0) + 1);

                    // 如果出现次数大于1，则说明该数独无效
                    if (rows[row].get(num) > 1 || cols[col].get(num) > 1 || boxes[idx].get(num) > 1) {
                        return false;
                    }
                }
            }
        }

        // 上面没有证伪，则说明数独有效
        return true;
    }


    public static void main(String[] args) {

        char[][] board1 = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board2 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println("数独1是否合法:" + isValidSudoku(board1));
        System.out.println("数独2是否合法:" + isValidSudoku(board2));
        System.out.println("----------------本次解答--------------->");
        System.out.println("数独1是否合法:" + myIsValidSudoku(board1));
        System.out.println("数独2是否合法:" + myIsValidSudoku(board2));
    }
}
