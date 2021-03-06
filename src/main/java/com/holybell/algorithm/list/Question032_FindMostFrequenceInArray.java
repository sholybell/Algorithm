package com.holybell.algorithm.list;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度:简单
 * <p>
 * 查找数组中重复次数最多的元素
 */
public class Question032_FindMostFrequenceInArray {

    /**
     * 查询数组内出现次数最多的元素
     *
     * @param a 数组
     */
    private static Map.Entry<Integer, Integer> myFindMostFrequencyInArray(int[] a) {
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
     * 查询数组内出现次数最多的元素
     *
     * @param a 数组
     */
    private static Map.Entry<Integer, Integer> findMostFrequencyInArray(int[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        // 使用HashMa保存每个成员出现次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : a) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 循环HashMap获得出现次数最多的成员
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3, 4, 4, 5, 4, 5, 5, 6, 6, 6, 6, 6};
        Map.Entry<Integer, Integer> maxEntry = findMostFrequencyInArray(a);
        System.out.println("正确答案:" + JSONObject.toJSONString(maxEntry));
        System.out.println("===========================");
        maxEntry = myFindMostFrequencyInArray(a);
        System.out.println("本次答案:" + JSONObject.toJSONString(maxEntry));
    }
}
