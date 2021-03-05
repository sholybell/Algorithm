package com.holybell.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度：中等
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * <p>
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
public class LeetCode22_generateParenthesis {

    /**
     * 给定n对括号，求有效的括号组合
     *
     * @param n 括号对数
     */
    private static List<String> myGenerateParenthesis(int n) {
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

    /**
     * 给定n对括号，求有效的括号组合
     * <p>
     * 直接穷举所有的排列组合，再重头遍历每个组合遇到(则+1，遇到)则-1，小于0或者最终不为0，为错误的排列
     *
     * @param n 括号对数
     */
    private static List<String> generateParenthesisV1(int n) {
        List<String> ans = new ArrayList<>();
        helper(new char[2 * n], ans, 0);
        return ans;
    }

    private static void helper(char[] chars, List<String> ans, int pos) {

        if (pos == chars.length) {
            if (valid(chars)) {
                ans.add(new String(chars));
            }
            return;
        }

        chars[pos] = '(';
        helper(chars, ans, pos + 1);
        chars[pos] = ')';
        helper(chars, ans, pos + 1);
    }

    private static boolean valid(char[] chars) {
        int count = 0;
        for (char ch : chars) {
            if (ch == '(') {
                count++;
            }
            if (ch == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    // --------------------------------------------------------------------

    /**
     * 给定n对括号，求有效的括号组合
     * <p>
     * 回溯法，每个位置能放置的情况如下:①左括号小于给定括号数量 ②右括号小于左括号个数
     *
     * @param n 括号对数
     */
    private static List<String> generateParenthesisV2(int n) {
        List<String> result = new ArrayList<>(n);

        if (n <= 0) {
            return result;
        }

        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * @param ans   输出结果集合
     * @param cur   当前的组合字符串
     * @param open  左括号使用数量
     * @param close 右括号使用数量
     * @param max   最大括号对数
     */
    private static void backtrack(List<String> ans, String cur, int open, int close, int max) {

        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        System.out.println("你的答案:");
        System.out.println("3对括号的组成:" + myGenerateParenthesis(3));
        System.out.println("----------------->");
        System.out.println("正确答案:");
        System.out.println("3对括号的组成:" + generateParenthesisV1(3));
    }

}
