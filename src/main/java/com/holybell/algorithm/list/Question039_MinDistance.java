package com.holybell.algorithm.list;

/**
 * 难度:简单
 * <p>
 * 如何求两个元素的最小距离
 * <p>
 * 给定一个数组，数组中含有重复元素，给出两个数n1和n2，求这两个数字在数组中出现位置的最小距离，
 * <p>
 * 例如，数组{4,5,6,4,7,4,6,7,8,5,6,4,3,10,8}中，4和8的最小距离为2.
 */
public class Question039_MinDistance {

    /**
     * 计算数组中两个指定数组最小距离
     *
     * @param a  指定数组
     * @param n1 数字1
     * @param n2 数字2
     */
    private static int myMinDistance(int[] a, int n1, int n2) {
        return Integer.MAX_VALUE;
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
     * 计算数组中两个指定数组最小距离
     *
     * @param a  指定数组
     * @param n1 数字1
     * @param n2 数字2
     */
    private static int minDistance(int[] a, int n1, int n2) {

        // 以下情况不处理
        if (a == null || a.length == 0) {
            return Integer.MAX_VALUE;
        }

        int distance = Integer.MAX_VALUE;

        // 定义两个表示数值位置的数字
        int pos1 = -1, pos2 = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == n1 || a[i] == n2) {
                // 分别计算两个元素的距离
                if (a[i] == n1) {
                    pos1 = i;
                    if (pos2 >= 0) {
                        distance = Math.min(distance, Math.abs(pos1 - pos2));
                    }
                }

                if (a[i] == n2) {
                    pos2 = i;
                    if (pos1 >= 0) {
                        distance = Math.min(distance, Math.abs(pos1 - pos2));
                    }
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int a[] = {4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8};
        System.out.println(minDistance(a, 4, 8));
        System.out.println(myMinDistance(a, 4, 8));
    }


}


