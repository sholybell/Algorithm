package com.holybell.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度:中等
 * <p>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
 * 列。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * <p>
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * Related Topics 二分查找 动态规划
 */
public class LeetCode300_lengthOfLIS {

    private static int myLengthOfLIS(int[] nums) {
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

    /**
     * 动态规划
     */
    private static int lengthOfLISV1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        // TODO 本递归公式用于表示当第i个元素组成递增子序列时，最大的数值
        int[] dp = new int[n];

        // 第一个元素自己构成一个递增子序列
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            // 首先，每个元素自己独立成为一个递增子序列
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // i位置的元素组成的最长上升序列由前面比它小的所有数字中构成的最长序列+1决定
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 最终结果要在dp数组中查询最大值
        return Arrays.stream(dp).max().getAsInt();
    }

    // --------------------------------------------------------------------

    /**
     * 递归
     */
    public int lengthOfLISV2(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        return helperV2(nums, -1, 0);
    }

    private static int helperV2(int[] nums, int prePos, int curPos) {

        // 查找到超出数组边界，返回0
        if (curPos == nums.length) {
            return 0;
        }

        int a = 0;
        int b = 0;

        // 除了最初的prePos=-1,curPos位置元素大于之前的元素，+1表示至少选定这个位置的元素
        if (prePos == -1 || nums[prePos] < nums[curPos]) {
            a = helperV2(nums, curPos, curPos + 1) + 1;
        }

        // 不选定curPos元素，curPos可能符合条件但放弃，也可能不符合条件
        b = helperV2(nums, prePos, curPos + 1);

        return Math.max(a, b);

    }

    // --------------------------------------------------------------------

    /**
     * 递归+记忆
     */
    private static int lengthOfLISV3(int[] nums) {

        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int n = nums.length;

        // 由于以下递归从-1开始，因此第一维度选用n+1
        int[][] cache = new int[n + 1][n];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }

        return helperV3(nums, -1, 0, cache);
    }

    private static int helperV3(int[] nums, int prePos, int curPos, int[][] cache) {

        if (curPos == nums.length) {
            return 0;
        }

        // prePos从-1开始，为避免越界，prePos 范围 [0,n]
        // 如果当前结果遍历过那么直接返回缓存结果
        if (cache[prePos + 1][curPos] != -1) {
            return cache[prePos + 1][curPos];
        }

        int a = 0;
        int b = 0;

        if (prePos == -1 || nums[prePos] < nums[curPos]) {
            a = helperV3(nums, curPos, curPos + 1, cache) + 1;
        }

        b = helperV3(nums, prePos, curPos + 1, cache);

        // 使用数组记录helper在[prePos,curPos]的解
        cache[prePos + 1][curPos] = Math.max(a, b);

        return cache[prePos + 1][curPos];
    }

    // --------------------------------------------------------------------

    /**
     * 贪心算法+二分查找
     * <p>
     * 本解法详情可以参看:
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/chao-xiang-xi-tu-jie-di-gui-dong-tai-gui-hua-er-fe/
     */
    private static int lengthOfLISV4(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        if (n == 1) {
            return 1;
        }

        // arr严格存储递增序列(且不重复)
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // arr为空，或者arr的最后一个元素小于nums[i]，在arr后面添加nums[i]
            if (arr.size() == 0 || arr.get(arr.size() - 1) < nums[i]) {
                arr.add(nums[i]);
                // 继续处理数组下一个元素
                continue;
            }

            // 如果发现nums[i] 小于等于arr最后一个元素，那么通过二分查找将arr中的某个元素替换为当前元素
            int lo = 0, hi = arr.size() - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr.get(mid) > nums[i]) {
                    hi = mid - 1;
                } else if (arr.get(mid) < nums[i]) {
                    lo = mid + 1;
                } else if (arr.get(mid) == nums[i]) {
                    lo = mid;   // TODO 如果arr中没有目标nums[i]，那么这个if将不会进来，返回的是比nums[i]大的最小元素，如果存在由于arr递增不重复，直接替换相同元素mid=lo退出循环
                    break;      // TODO 没有这个将会产生死循环
                }
            }

            arr.set(lo, nums[i]);   // TODO 此时lo表示arr数组中有多少个元素小于nums[i]，set替换元素
        }

        return arr.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("你的答案:");
        System.out.println("数组 : " + Arrays.toString(nums) + " 最长上升子序列长度 : " + myLengthOfLIS(nums));
        System.out.println("------------------------------>");
        System.out.println("正确答案:");
        System.out.println("数组 : " + Arrays.toString(nums) + " 最长上升子序列长度 : " + lengthOfLISV1(nums));
        System.out.println("数组 : " + Arrays.toString(nums) + " 最长上升子序列长度 : " + lengthOfLISV4(nums));
    }
}
