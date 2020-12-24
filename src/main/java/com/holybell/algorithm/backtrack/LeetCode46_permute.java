package com.holybell.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 难度：中等
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class LeetCode46_permute {

    private static List<List<Integer>> _permute(int[] nums) {
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

    /**
     * 给定一个不重复的数字集合，计算全排列
     *
     * @param nums 数字集合
     */
    private static List<List<Integer>> permute(int[] nums) {
        // 记录最终结果
        List<List<Integer>> result = new ArrayList<>();
        // 记录单词回溯结果
        List<Integer> track = new ArrayList<>();
        backtrack(nums, track, result);
        return result;
    }

    /**
     * 回溯算法计算不重复数字的全排列
     *
     * @param nums   不重复数字集合
     * @param track  单次排列结果
     * @param result 缓存每个单次排列的结果
     */
    private static void backtrack(int[] nums, List<Integer> track, List<List<Integer>> result) {
        // 单次结果已经填满给定的数字个数
        if (track.size() == nums.length) {
            // 记录一次结果，注意这里需要重新封装track对象，否则每次添加进去的都是同一个List，而回溯算法一直在增删这个List
            result.add(new ArrayList<>(track));
        } else {
            // 尝试判断每个数字是否可以使用
            for (int num : nums) {
                // 已经被采纳的数字不再处理
                if (track.contains(num)) {
                    continue;
                }
                // 采纳这个数字
                track.add(num);
                // 进入下一层递归
                backtrack(nums, track, result);
                // 回溯，將前面采纳的数字作废，注意remove方法传入基本类型和传入Object类型的差异
                track.remove(Integer.valueOf(num));
            }
        }


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println("你的答案:");
        List<List<Integer>> permuteList = _permute(nums);
        if (Optional.ofNullable(permuteList).isPresent()) {
            permuteList.stream().forEach(list -> System.out.println(list));
        }
        System.out.println("=================================");
        System.out.println("正确答案:");
        permuteList = permute(nums);
        if (Optional.ofNullable(permuteList).isPresent()) {
            permuteList.stream().forEach(list -> System.out.println(list));
        }

    }
}
