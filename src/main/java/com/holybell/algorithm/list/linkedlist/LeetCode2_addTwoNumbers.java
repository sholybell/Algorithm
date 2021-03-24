package com.holybell.algorithm.list.linkedlist;

import com.holybell.algorithm.common.ListNode;
import com.holybell.algorithm.common.util.ListUtil;

import java.util.Arrays;

/**
 * 难度:中等
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * Related Topics 递归 链表 数学
 */
public class LeetCode2_addTwoNumbers {

    private static ListNode myAddTwoNumbers(ListNode l1, ListNode l2) {
        return new ListNode();
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

    private static ListNode addTwoNumbersV1(ListNode l1, ListNode l2) {

        // 可能存在链表形式[0,8,6,5,6,8,3,5,7]，即个位数为0的数字，因此判断0需要同时满足：1. node.val==0 2. node.next == null 两个条件
        if (l1.val == 0 && l1.next == null) {
            return l2;
        }
        if (l2.val == 0 && l2.next == null) {
            return l1;
        }

        ListNode dummy = new ListNode();
        ListNode pre = null;
        dummy.next = pre;
        // 记录下一位数字需不需要因为进1而额外+1
        boolean plusOne = false;
        // TODO 如果这里优化成 l1 != null && l2 != null 解法，将大幅缩短题解长度
        while (l1 != null && l2 != null) {

            ListNode node = new ListNode();
            // TODO 该如何优雅的处理前继节点问题？？？？？？
            if (pre == null) {
                dummy.next = node;
            } else {
                pre.next = node;
            }

            int num = l1.val + l2.val;
            // 判断当前节点值是否需要进1
            if (plusOne) {
                num += 1;
                // 进1完毕，标志位重置
                plusOne = false;
            }

            // 判断当前节点的值是否>=10，满足条件标记下一位数字需要进1
            if (num >= 10) {
                plusOne = true;
                node.val = num % 10;
            } else {
                node.val = num;
            }

            // 将此节点设置为前置节点，链表1、2各自后移一个节点
            pre = node;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 若链表长度不一致，剩下的链表在判断是否需要进1的情况下，接入前面计算好的链表后
        while (l1 != null) {
            ListNode node = l1;
            pre.next = node;

            int num = node.val;
            if (plusOne) {
                num += 1;
                plusOne = false;
            }

            if (num >= 10) {
                plusOne = true;
                node.val = num % 10;
            } else {
                node.val = num;
            }

            pre = node;
            l1 = l1.next;
        }
        // 若链表长度不一致，剩下的链表在判断是否需要进1的情况下，接入前面计算好的链表后
        while (l2 != null) {
            ListNode node = l2;
            pre.next = node;
            int num = node.val;
            if (plusOne) {
                num += 1;
                plusOne = false;
            }

            if (num >= 10) {
                plusOne = true;
                node.val = num % 10;
            } else {
                node.val = num;
            }

            pre = node;
            l2 = l2.next;
        }

        // 可能出现[1,8] [2,9]  即81+92=173，即两数之和比原来的数字位数多了1，由于链表是逆序表示，链表末尾追加1
        if (plusOne) {
            pre.next = new ListNode(1);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 4, 3};
        int[] nums2 = new int[]{5, 6, 4};
        int[] nums3 = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] nums4 = new int[]{9, 9, 9, 9};

        System.out.println("你的答案:");
        System.out.println("逆序链表 : " + Arrays.toString(nums1) + " 和 " + Arrays.toString(nums2) + " 和的逆序链表为 : " + ListUtil.printLinkedList(myAddTwoNumbers(ListUtil.createLinkedList(nums1), ListUtil.createLinkedList(nums2))));
        System.out.println("逆序链表 : " + Arrays.toString(nums3) + " 和 " + Arrays.toString(nums4) + " 和的逆序链表为 : " + ListUtil.printLinkedList(myAddTwoNumbers(ListUtil.createLinkedList(nums3), ListUtil.createLinkedList(nums4))));
        System.out.println("---------------------------->");
        System.out.println("正确答案:");
        System.out.println("逆序链表 : " + Arrays.toString(nums1) + " 和 " + Arrays.toString(nums2) + " 和的逆序链表为 : " + ListUtil.printLinkedList(addTwoNumbersV1(ListUtil.createLinkedList(nums1), ListUtil.createLinkedList(nums2))));
        System.out.println("逆序链表 : " + Arrays.toString(nums3) + " 和 " + Arrays.toString(nums4) + " 和的逆序链表为 : " + ListUtil.printLinkedList(addTwoNumbersV1(ListUtil.createLinkedList(nums3), ListUtil.createLinkedList(nums4))));
    }
}
