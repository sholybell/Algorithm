package com.holybell.algorithm.twopointer;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 难度:中等
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
 * d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [], target = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * <p>
 * Related Topics 数组 哈希表 双指针
 */
public class LeetCode18_fourSum {

    private static List<List<Integer>> myFourSum(int[] nums, int target) {
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

    /**
     * 解法类似{@link LeetCode15_threeSum}
     * 采用两层循环，左右指针
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        // 将数组排序，才能使用左右指针
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        // 注意边界问题，还有3个位置，因此nums.length-3
        for (int i = 0; i < nums.length - 3; i++) {
            // 这层循环表示集合第一个位置，不要重用重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 注意边界问题，还有2个位置，因此nums.length-2
            // 并且从第一层循环后一个位置开始
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 这层循环表示集合的第二个位置，不要重复的元素，并且判重从第一层循环后一个元素开始，不往前判断第一重循环占据的元素（属于集合第一个位置）
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]) {

                        }
                        while (left < right && nums[right] == nums[--right]) {

                        }
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        while (left < right && nums[right] == nums[--right]) {

                        }
                    } else {
                        while (left < right && nums[left] == nums[++left]) {

                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 0, 0};
        int[] nums2 = new int[]{-2, -1, -1, 1, 1, 2, 2};
        int[] nums3 = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        int[] nums4 = new int[]{1, 0, -1, 0, -2, 2};

        System.out.println("你的答案:");
        System.out.println(Arrays.toString(nums1) + " 不重复四元组和为0 :" + JSONObject.toJSONString(myFourSum(nums1, 0)));
        System.out.println(Arrays.toString(nums2) + " 不重复四元组和为0 :" + JSONObject.toJSONString(myFourSum(nums2, 0)));
        System.out.println(Arrays.toString(nums3) + " 不重复四元组和为-11 :" + JSONObject.toJSONString(myFourSum(nums3, 0)));
        System.out.println(Arrays.toString(nums4) + " 不重复四元组和为0 :" + JSONObject.toJSONString(myFourSum(nums4, 0)));
        System.out.println();
        System.out.println("正确答案:");
        System.out.println(Arrays.toString(nums1) + " 不重复四元组和为0 :" + JSONObject.toJSONString(fourSum(nums1, 0)));
        System.out.println(Arrays.toString(nums2) + " 不重复四元组和为0 :" + JSONObject.toJSONString(fourSum(nums2, 0)));
        System.out.println(Arrays.toString(nums3) + " 不重复四元组和为-11 :" + JSONObject.toJSONString(fourSum(nums3, 0)));
        System.out.println(Arrays.toString(nums4) + " 不重复四元组和为0 :" + JSONObject.toJSONString(fourSum(nums4, 0)));
    }
}
