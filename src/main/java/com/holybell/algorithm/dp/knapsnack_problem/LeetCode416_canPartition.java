package com.holybell.algorithm.dp.knapsnack_problem;

import java.util.Arrays;

/**
 * 难度:中等
 * <p>
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * <p>
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * <p>
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * <p>
 * Related Topics 动态规划
 */
public class LeetCode416_canPartition {

    public boolean myCanPartition(int[] nums) {
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

    /**
     * 动态规划
     */
    public boolean canPartitionV1(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }

        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }

        // 总和为奇数无解
        if ((sum & 1) == 1) {
            return false;
        }

        // 最大数大于总和一半无解
        if (maxNum > sum / 2) {
            return false;
        }

        int target = sum / 2;
        // 表示存在前面i个数字和为j的组合
        boolean[][] dp = new boolean[nums.length][target + 1];

        // 只要不选择，那么前面无论多少个数字总和都可以为0
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        // 题目表明只有正整数，除非第一个数字和目标和一致，否则没有其他可能
        for (int i = 0; i <= target; i++) {
            if (nums[0] == i) {
                dp[0][i] = true;
            } else {
                dp[0][i] = false;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][target];
    }

    // --------------------------------------------------------------------

    private boolean canPartition = false;

    /**
     * 递归解法，本解法leetCode超时
     */
    public boolean canPartitionV2(int[] nums) {

        canPartition = false;

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }

        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }

        // 总和为奇数无解
        if ((sum & 1) == 1) {
            return false;
        }

        // 最大数大于总和一半无解
        if (maxNum > sum / 2) {
            return false;
        }

        int target = sum / 2;

        helper(nums, target, 0, 0);

        return canPartition;
    }

    private void helper(int[] nums, int target, int pos, int preSum) {
        //  数组遍历完毕，已经求得集合的和的一半，其他递归已经得到解答  直接返回不再递归
        if (pos == nums.length || preSum == target || canPartition) {
            if (preSum == target) {
                canPartition = true;
            }
            return;
        }

        // 当前数字不采用
        helper(nums, target, pos + 1, preSum);
        // 当前数字采用
        helper(nums, target, pos + 1, preSum + nums[pos]);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 5, 11, 5};
        int[] nums2 = new int[]{20, 10, 9, 8, 8, 3};
        LeetCode416_canPartition canPartition = new LeetCode416_canPartition();
        System.out.println("你的答案:");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 是否可以分割成两个等和集合 : " + canPartition.myCanPartition(nums1));
        System.out.println("数组 : " + Arrays.toString(nums2) + " 是否可以分割成两个等和集合 : " + canPartition.myCanPartition(nums2));
        System.out.println("------------------------------>");
        System.out.println("正确答案:");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 是否可以分割成两个等和集合 : " + canPartition.canPartitionV1(nums1));
        System.out.println("数组 : " + Arrays.toString(nums2) + " 是否可以分割成两个等和集合 : " + canPartition.canPartitionV2(nums2));
    }
}
