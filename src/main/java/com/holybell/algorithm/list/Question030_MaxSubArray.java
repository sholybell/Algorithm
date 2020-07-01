package com.holybell.algorithm.list;

/**
 * 难度：困难
 * <p>
 * 从给定数组中找到连续子数组和最大的值
 */
public class Question030_MaxSubArray {

    // 就不去考虑使用双重循环了~~~~~~



    // 3.动态规划，可以推出一个结论 取数组某一个位置，到这个元素连续路径的最大值一定在以下三种情况之一：
    // ①元素自己构成最大路径
    // ②元素自己和前面几个连续的元素构成最大路径
    // ③元素自己不构成最大路径，前面已经有连续子数组构成最大路径，因此获取前一位的最大路径计算结果。
    // 前一位的的判断也和本次判断类似
    private static int myMaxSubArray(int[] a) {

        return Integer.MIN_VALUE;
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

    // 3.动态规划，可以推出一个结论 取数组某一个位置，到这个元素连续路径的最大值一定在以下三种情况之一：
    // ①元素自己构成最大路径
    // ②元素自己和前面几个连续的元素构成最大路径
    // ③元素自己不构成最大路径，前面已经有连续子数组构成最大路径，因此获取前一位的最大路径计算结果。
    // 前一位的的判断也和本次判断类似
    private static int maxSubArray(int[] a) {

        // 不处理空数组
        if (a == null || a.length == 0) {
            return Integer.MIN_VALUE;
        }

        // 到一个位置，最大值三种选择，①前面最大值自己，②前面最大值加上当前值，③当前值自己构成最大值

        int[] End = new int[a.length];        //记录到这个位置，连续的子数组组成的最大值，只有两种情况，包含当前下标，或者当前下标自己最大
        int[] ALL = new int[a.length];        //记录到这个位置，统计到的连续子序列之和的最大值是多少

        End[0] = ALL[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            // END[i-1]表示前一个位置确认的最大值，END[i-1]+a[i]表示前面最大值+当前位置值，a[i]表示自己是最大值

            // 从前面最大值+当前值、当前值中取大者
            End[i] = Integer.max(End[i - 1] + a[i], a[i]); //
            // 从上一行的最大值、上一个位置最大值ALL[i-1](其实就是end[i-1])取大值，即为当前位置三种情况的最大值
            ALL[i] = Integer.max(End[i], ALL[i - 1]);    //ALL是用解决上面如果END[i-1]前面连续比END[i]前面连续大的情况，一直使用大的值覆盖到当前节点
        }
        return ALL[a.length - 1];
    }

    public static void main(String[] args) {
        int a[] = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println("正确答案:" + maxSubArray(a));
        System.out.println("==========");
        System.out.println("本次答案:" + myMaxSubArray(a));
    }
}
