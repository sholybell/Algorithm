package com.holybell.algorithm.dp;

import java.util.Arrays;

/**
 * 难度:中等
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * <p>
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * <p>
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * Related Topics 数组 动态规划
 */
public class LeetCode152_maxProduct {

    private static int myMaxProduct(int[] nums) {
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

    private static int maxProductV1(int[] nums) {

        int n = nums.length;

        int[] maxDp = new int[n];
        int[] minDp = new int[n];

        maxDp[0] = minDp[0] = nums[0];

        int max = minDp[0];
        for (int i = 1; i < n; i++) {
            // TODO 由于乘法存在负负得正的情况，因此通过计算每一个未知乘积的最大值和最小值，用于下一个位置的判断
            maxDp[i] = Math.max(nums[i], Math.max(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(nums[i], Math.min(maxDp[i - 1] * nums[i], minDp[i - 1] * nums[i]));
            max = Math.max(max, maxDp[i]);
        }

        return max;
    }

    // --------------------------------------------------------------------

    private static long max = Long.MIN_VALUE;

    /**
     * 递归解法
     */
    private static int maxProductV2(int[] nums) {

        // 重置全局变量
        max = Long.MIN_VALUE;

        if (nums.length == 1) {
            return nums[0];
        }

        helper(nums, 1, 0);
        return (int) max;
    }

    private static void helper(int[] nums, long product, int pos) {
        if (pos == nums.length) {
            return;
        }

        long _product = product * nums[pos];
        max = Math.max(Math.max(max, _product), nums[pos]);

        // 当前元素加入上一批子序列
        helper(nums, _product, pos + 1);
        // 当前元素成为新的一批子序列的开始
        helper(nums, nums[pos], pos + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 3, -2, 4};
        int[] nums2 = new int[]{-2, 0, -1};
        int[] nums3 = new int[]{0, -1, 4, -4, 5, -2, -1, -1, -2, -3, 0, -3, 0, 1, -1, -4, 4, 6, 2, 3, 0, -5, 2, 1, -4, -2, -1, 3, -4, -6, 0, 2, 2, -1, -5, 1, 1, 5, -6, 2, 1, -3, -6, -6, -3, 4, 0, -2, 0, 2};
        System.out.println("你的答案:");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 最大子数组乘积 : " + myMaxProduct(nums1));
        System.out.println("数组 : " + Arrays.toString(nums2) + " 最大子数组乘积 : " + myMaxProduct(nums2));
//        System.out.println("数组 : " + Arrays.toString(nums3) + " 最大子数组乘积 : " + myMaxProduct(nums3));
        System.out.println("---------------------->");
        System.out.println("正确答案:");
        System.out.println("数组 : " + Arrays.toString(nums1) + " 最大子数组乘积 : " + maxProductV1(nums1));
        System.out.println("数组 : " + Arrays.toString(nums2) + " 最大子数组乘积 : " + maxProductV1(nums2));
//        System.out.println("数组 : " + Arrays.toString(nums3) + " 最大子数组乘积 : " + maxProduct(nums3));
    }
}
