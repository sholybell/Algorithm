package com.holybell.algorithm.string;

/**
 * 难度:简单
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * <p>
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * <p>
 * Related Topics 字符串
 */
public class LeetCode58_lengthOfLastWord {

    public int lengthOfLastWord(String s) {
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
     * 从字符串最后开始统计，性能最好
     */
    public int lengthOfLastWordV1(String s) {
        // 题目说明字符串长度 [1,104],无需盘空

        char[] chs = s.toCharArray();

        int end = chs.length - 1;
        // 从最后一个字符开始往左遍历，第一个非空白字符
        while (end >= 0 && chs[end] == ' ') {
            end--;
        }

        // 字符串s未找到非空白字符
        if (end == -1) {
            return 0;
        }

        // 查找最后一个字母，结果查找到第一个字符，说明字符串仅仅第一个字符为字母
        if (end == 0) {
            return 1;
        }

        int start = end - 1;
        while (start >= 0 && chs[start] != ' ') {   // "[]ab"  "ab"  start要么为最后一个单词前的一个空格 要么为-1
            start--;
        }

        // start=-1时   end - 0 +1  = end - start(-1)
        // start!=-1时  end - (start+1)-1 = end - start;
        return end - start;
    }

    // --------------------------------------------------------------------

    public int lengthOfLastWordV2(String s) {
        // 题目说明字符串长度 [1,104],无需盘空

        // 去左右空格
        s = s.trim();
        // 根据空格切分
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    // --------------------------------------------------------------------

    /**
     * 性能并不比V2高
     */
    public int lengthOfLastWordV3(String s) {

        // 题目说明字符串长度 [1,104],无需盘空

        // " ABC "

        char[] chs = s.toCharArray();

        boolean newWord = true;

        // 记录一个单词的头字符位置
        int wordStart = 0;

        // 记录每一个单词长度
        int len = 0;
        for (int i = 0; i < chs.length; i++) {
            // 当前字符不为空格 且 当且为一个新的单词开头
            if (chs[i] != ' ' && newWord) {
                // 遇到一个新的单词，下一个非空格字母进来不再是单词头字母
                newWord = false;
                wordStart = i;
            } else if (chs[i] == ' ' && !newWord) { // 再次遇到单词之后的第一个空格
                // "ABC[][]CD"  注意连续空格的情况
                // 设置标志位，下次遇到非空白字符就是一个新单词的头部，同时避免连续空格的影响
                newWord = true;
                // 覆盖每一个遇到的单词长度
                len = (i - 1) - wordStart + 1;
            }

            if (i == chs.length - 1) { // 到了字符串的尾部
                // "AAA[][]" 如果最后一个字符是空格什么也不做，因为如果之前有单词已经计算过长度

                // 最后一个字符不是空格   "    a" 独立一个if处理最后一个字符的情况，避免最后一个单词就一个字母
                if (chs[i] != ' ') {
                    len = i - wordStart + 1;
                }
            }
        }

        return len;
    }

    public static void main(String[] args) {
        LeetCode58_lengthOfLastWord lengthOfLastWord = new LeetCode58_lengthOfLastWord();
        String str1 = "Hello World", str2 = " ", str3 = "     a";
        System.out.println("你的答案:");
        System.out.println("字符串 : [" + str1 + "] 最后一个单词长度 : " + lengthOfLastWord.lengthOfLastWord(str1));
        System.out.println("字符串 : [" + str2 + "] 最后一个单词长度 : " + lengthOfLastWord.lengthOfLastWord(str2));
        System.out.println("字符串 : [" + str3 + "] 最后一个单词长度 : " + lengthOfLastWord.lengthOfLastWord(str3));
        System.out.println("---------------------------->");
        System.out.println("正确答案:");
        System.out.println("字符串 : [" + str1 + "] 最后一个单词长度 : " + lengthOfLastWord.lengthOfLastWordV1(str1));
        System.out.println("字符串 : [" + str2 + "] 最后一个单词长度 : " + lengthOfLastWord.lengthOfLastWordV2(str2));
        System.out.println("字符串 : [" + str3 + "] 最后一个单词长度 : " + lengthOfLastWord.lengthOfLastWordV3(str3));
    }
}
