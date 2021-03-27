package com.holybell.algorithm.dp.knapsnack_problem;

import java.util.Arrays;

/**
 * 难度:中等
 * <p>
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3  (数组每一个元素都必须参与计算！)
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * <p>
 * <p>
 * 提示：
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 * <p>
 * Related Topics 深度优先搜索 动态规划
 */
public class LeetCode494_findTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
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

    private int count = 0;

    /**
     * 递归解法
     */
    public int findTargetSumWaysV1(int[] nums, int S) {
        count = 0;
        helperV1(nums, S, 0, 0);
        return count;
    }

    private void helperV1(int[] nums, int S, int preSum, int pos) {

        // 每一个元素都必须参与计算，同时和恰好为S
        if (pos == nums.length && preSum == S) {
            count++;
            return;
        }

        if (pos == nums.length) {
            return;
        }

        helperV1(nums, S, preSum + nums[pos], pos + 1);
        helperV1(nums, S, preSum - nums[pos], pos + 1);
    }

    // --------------------------------------------------------------------

    /**
     * 动态规划
     */
    public int findTargetSumWaysV2(int[] nums, int S) {

        // S不能超过题目给定的范围
        if (S > 1000 || S < -1000) {
            return 0;
        }

        int n = nums.length;

        // 数组和不会超过1000，那么结果可能为[-1000,10000] 含0 共2001个数字
        // dp[i][j]表示前i个数合计为j的方案数量
        int[][] dp = new int[n][2001];

        dp[0][nums[0] + 1000] = 1;
        // 若nums[0]==0的情况那么   dp[nums[0] + 1000]==dp[-nums[0] + 1000]
        dp[0][-nums[0] + 1000] += 1;

        for (int i = 1; i < n; i++) {
            for (int j = -1000; j <= 1000; j++) {

                // TODO 每一个dp[i][j] 都可以从 dp[i-1][j-nums[i]] 和 dp[i-1][j+nums[i]]过来

                // 避免数组越界
                if (j - nums[i] + 1000 >= 0) {
                    dp[i][j + 1000] = dp[i][j + 1000] + dp[i - 1][j - nums[i] + 1000];  // 此时dp[i][j + 1000]=0
                }
                // 避免数组越界
                if (j + nums[i] + 1000 <= 2000) {
                    dp[i][j + 1000] = dp[i][j + 1000] + dp[i - 1][j + nums[i] + 1000];  // 此时dp[i][j + 1000]已经有了j-nums[i]过来的方案数量
                }
            }
        }

        // 由于dp[i][j]第二维度被+1000进行DP，这里需要使用S+1000
        return dp[n - 1][S + 1000];
    }

    public static void main(String[] args) {
        LeetCode494_findTargetSumWays findTargetSumWays = new LeetCode494_findTargetSumWays();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println("你的答案:");
        System.out.println("数组 : " + Arrays.toString(nums) + " 和为3的解答共有 : " + findTargetSumWays.findTargetSumWays(nums, 3));
        System.out.println("------------------------>");
        System.out.println("正确答案:");
        System.out.println("数组 : " + Arrays.toString(nums) + " 和为3的解答共有 : " + findTargetSumWays.findTargetSumWaysV1(nums, 3));
        System.out.println("数组 : " + Arrays.toString(nums) + " 和为3的解答共有 : " + findTargetSumWays.findTargetSumWaysV2(nums, 3));
    }
}