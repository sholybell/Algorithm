package com.holybell.algorithm.bit;

/**
 * 难度:简单
 * <p>
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * <p>
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
 * 还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -10737418
 * 25。
 * <p>
 * <p>
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 * <p>
 * <p>
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p>
 * <p>
 * 示例 2：
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p>
 * <p>
 * 示例 2：
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *   因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * <p>
 * <p>
 * 提示：
 * 输入是一个长度为 32 的二进制字符串
 * <p>
 * Related Topics 位运算
 */
public class LeetCode190_reverseBits {

    public int reverseBits(int n) {
        return 0;
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

    public int reverseBitsV1(int n) {

        // 0直接返回0
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        // 32位二进制数
        for (int i = 0; i < 32; i++) {
            // n&1用来获得当前n的最后一位是0或者1  然后这个数字可以往左移动[0,31]个位置
            // 由于ans初始都是0，使用或，0|1=1 ; 0|0=0
            ans = ans | ((n & 1) << (31 - i));
            // 每次将0或者1移动相应位置之后，n往右移动一位，用于判断下一次要移位的是0还是1
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode190_reverseBits reverseBits = new LeetCode190_reverseBits();
        System.out.println("你的答案:");
        System.out.println("------------------------->");
        System.out.println("43261596 颠倒二进制位后为 : "+ reverseBits.reverseBits(43261596));
        System.out.println("正确答案:");
        System.out.println("43261596 颠倒二进制位后为 : "+ reverseBits.reverseBitsV1(43261596));
    }
}
