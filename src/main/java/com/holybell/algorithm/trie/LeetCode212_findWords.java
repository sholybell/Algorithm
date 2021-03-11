package com.holybell.algorithm.trie;

import com.holybell.algorithm.common.Trie;
import com.holybell.algorithm.common.util.ArrayUtil;

import java.util.*;

/**
 * 难度:困难
 * <p>
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * 输入: words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * <p>
 * 说明:你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * <p>
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？
 * <p>
 * 如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 {@link LeetCode208_Trie}
 * <p>
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 */
public class LeetCode212_findWords {


    /**
     * 求证一组单词是否出现在一个矩阵中
     *
     * @param board 字母矩阵
     * @param words 单词列表
     */
    private static List<String> myFindWords(char[][] board, String[] words) {
        return new ArrayList<>();
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

    private static Set<String> res = new HashSet<>();

    /**
     * 求证一组单词是否出现在一个矩阵中
     *
     * @param board 字母矩阵
     * @param words 单词列表
     */
    private static List<String> findWords(char[][] board, String[] words) {

        res.clear();

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 深度遍历，尝试在矩阵的上下左右移动，判断当前坐标是否可用
     *
     * @param board   字母矩阵
     * @param visited 是否使用过当前坐标
     * @param str     矩阵路径连接的字符串(TODO 注意使用String和StringBuilder在回溯操作中的区别)
     * @param x       x坐标
     * @param y       y坐标
     * @param trie    前缀树
     */
    private static void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {

        // x,y表示当前要判断的坐标位置是否可以采纳，坐标位置不能超过矩阵范围
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        // 如果当前坐标访问过，就不要再尝试了，因为要么已经符合，要么不符合了
        if (visited[x][y]) {
            return;
        }

        // 将矩阵上面走过的路径连成一个字符串
        str += board[x][y];

        // 首先字符串必须在前缀树中存在前缀，如果不存在说明肯定不是一个单词
        if (!trie.startsWith(str)) {
            return;
        }

        // 如果前缀存在，进一步在判断是否是一个单词，其实上面一步可以不判断，直接判断是否是一个单词也可以
        if (trie.search(str)) {
            res.add(str);   // 这里不能直接就返回了，有可能当前路径继续往下走还有另一个单词 比如：apple  apples 两个单词
        }

        // 采用当前坐标
        visited[x][y] = true;
        // 尝试在当前坐标的基础上往四个方向走动
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        // 当前坐标四个方向都没有结果，重新标记为未访问过，让其他路径可以路过该坐标
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        char[][] board2 = new char[][]{
                {'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}
        };
        char[][] board3 = new char[][]{
                {'a'}
        };

        System.out.println("二维网格1:");
        ArrayUtil.printBoard(board1);
        String[] words1 = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println("二维网格2:");
        ArrayUtil.printBoard(board2);
        String[] words2 = new String[]{"oa", "oaa"};
        System.out.println("二维网格3:");
        ArrayUtil.printBoard(board3);
        String[] words3 = new String[]{"a"};

        System.out.println("你的答案:");
        System.out.println("二维网格1包含单词数组 " + Arrays.toString(words1) + " 中的: " + myFindWords(board1, words1));
        System.out.println("二维网格2包含单词数组 " + Arrays.toString(words2) + " 中的: " + myFindWords(board2, words2));
        System.out.println("二维网格3包含单词数组 " + Arrays.toString(words3) + " 中的: " + myFindWords(board3, words3));

        System.out.println("---------------------->");

        System.out.println("正确答案:");
        System.out.println("二维网格1包含单词数组 " + Arrays.toString(words1) + " 中的: " + findWords(board1, words1));
        System.out.println("二维网格2包含单词数组 " + Arrays.toString(words2) + " 中的: " + findWords(board2, words2));
        System.out.println("二维网格3包含单词数组 " + Arrays.toString(words3) + " 中的: " + findWords(board3, words3));

    }

}