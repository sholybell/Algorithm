package com.holybell.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 难度:中等
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * Related Topics 字符串
 */
public class LeetCode6_convert {

    public String convert(String s, int numRows) {
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

    public String convertV1(String s, int numRows) {

        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        numRows = Math.min(s.length(), numRows);

        char[] chs = s.toCharArray();

        List<StringBuilder> sbList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }

        // n=4
        // 第0行两个字符差距 P（0） I(6)
        // 第1行两个字符差距 A（1） L（5）
        // 第2行            Y（2） A（4）
        // 第3行            P(3)

        // 2n-2 -1

        // n-1-3

        for (int i = 0; i <= chs.length / (2 * numRows - 2); i++) {
            // 一个批次的头指针开始
            for (int pos = i * (2 * numRows - 2); pos < (i + 1) * (2 * numRows - 2) && pos < chs.length; pos++) {
                // 计算当前节点距离一个批次的头字符的偏移量
                int offset = pos % (2 * numRows - 2);
                // 一个批次的[0,numRows-1]行字符直接添加
                if (offset <= (numRows - 1)) {
                    sbList.get(offset).append(chs[pos]);
                } else {
                    // [1,numRows-2]行，除了头尾两行的中间行，额外要添加的尾部几个元素
                    sbList.get(numRows - (offset - numRows) - 2).append(chs[pos]);
                }
            }

        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : sbList) {
            ans.append(sb.toString());
        }
        return ans.toString();
    }

    // --------------------------------------------------------------------

    /**
     * 使用一个标记goingDown，表示当前字符应该往上还是往下填写
     */
    public String convertV2(String s, int numRows) {

        // 若字符串长度为1 或者 Z字型就1行，那么直接返回字符串即可
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        // 若字符串长度不足给定行数numRows，那么只需要字符串长度行数即可
        numRows = Math.min(s.length(), numRows);

        // 声明一个集合，存储Z字型每一行字符串
        List<StringBuilder> sbList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }

        char[] chs = s.toCharArray();

        //  表示当前要添加字符的行
        int curRow = 0;
        // 表示当前添加字符是往上或者往下
        boolean goDown = false;

        for (int i = 0; i < chs.length; i++) {
            sbList.get(curRow).append(chs[i]);
            // 当前添加的行到达首行和尾行，转方向添加
            if (curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
            // 根据当前要添加的方向，对下一次循环要添加的行做+1或者-1操作
            curRow = goDown ? (curRow + 1) : (curRow - 1);
        }

        // 最后，合并每一行的结果
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : sbList) {
            ans.append(sb);
        }
        return ans.toString();
    }

    // --------------------------------------------------------------------

    public String convertV3(String s, int numRows) {

        // 若字符串长度为1 或者 Z字型就1行，那么直接返回字符串即可
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        numRows = Math.min(s.length(), numRows);

        char[] chs = s.toCharArray();
        int cycLen = 2 * numRows - 2;       // 代表从第0行开始到下一个第0行前一个元素之间的字符格式，代表一个批次的长度

        List<StringBuilder> sbList = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }

        // 通过观察可以得知 Z字形行中，第一行中字符在字符串的位置，存在如下表达式 : k*(2*numsRows -2) (k>=0)

        for (int i = 0; i < numRows; i++) { // 对于每一行操作，直接在找到字符串中对应该行的字符
            for (int j = 0; j + i < chs.length; j = j + cycLen) {   // TODO 这里的j在一次循环中都是不变的，通过j+i的变动来获取不同批次的字符
                // 每一行固定一定要添加一个元素(第0行 - 第numRows-1行往下方向一定有一个字符要添加)  k*(2*numsRows -2)+i
                sbList.get(i).append(chs[j + i]);
                // 除了第一行和最后一行，中间的每一行都需要添加第二个字符，第二个字符刚好相当于下一个 (k+1)*(2*numsRows -2)-i
                if (i != 0 && i != numRows - 1 && (j + cycLen) - i < chs.length) {
                    sbList.get(i).append(chs[(j + cycLen) - i]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : sbList) {
            ans.append(sb);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode6_convert convert = new LeetCode6_convert();
        String str1 = "PAYPALISHIRING", str2 = "A", str3 = "AB";
        System.out.println("你的答案:");
        System.out.println("字符串 : " + str1 + " Z字排序结果 : " + convert.convert("PAYPALISHIRING", 3));
        System.out.println("字符串 : " + str2 + " Z字排序结果 : " + convert.convert("A", 1));
        System.out.println("字符串 : " + str3 + " Z字排序结果 : " + convert.convert("AB", 1));
        System.out.println("-------------------------->");
        System.out.println("正确答案:");
        System.out.println("字符串 : " + str1 + " Z字排序结果 : " + convert.convertV3("PAYPALISHIRING", 3));
        System.out.println("字符串 : " + str2 + " Z字排序结果 : " + convert.convertV3("A", 1));
        System.out.println("字符串 : " + str3 + " Z字排序结果 : " + convert.convertV3("AB", 1));
    }
}
