package com.holybell.algorithm.list.linkedlist;

import com.holybell.algorithm.common.ListNode;
import com.holybell.algorithm.common.util.ListUtil;

/**
 * 难度:中等
 * <p>
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * <p>
 * Related Topics 链表
 */
public class LeetCode82_deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        return new ListNode(Integer.MIN_VALUE);
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

    public ListNode deleteDuplicatesV1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }


    // --------------------------------------------------------------------

    public ListNode deleteDuplicatesV2(ListNode head) {

        // 链表0个节点和1个节点的情况直接返回head
        if (head == null || head.next == null) {
            return head;
        }

        // 节点值[-100, 100]
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode curNode = head;

        // 之前前继节点的值(未对链表做删除操作时)
        int preVal = preNode.val;
        while (curNode != null) {

            // 当前节点值和前继节点值一致如[2, (2), 3]或者 当前节点值和后继节点值一致如[ 2, (3), 3]括号表示当前节点
            if (preVal == curNode.val || (curNode.next != null && curNode.val == curNode.next.val)) {
                // 前继节点指向后继节点，相当于删除当前节点
                preNode.next = curNode.next;
                // 前继节点值保存为当前节点值
                preVal = curNode.val;

                ListNode tmpNode = curNode;
                // 当前节点指向下一个节点
                curNode = curNode.next;
                // 将当前节点的next设置为null，辅助GC
                tmpNode.next = null;
            } else {
                preNode = curNode;
                // 前继节点值保存为当前节点值
                preVal = curNode.val;
                curNode = curNode.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode82_deleteDuplicates deleteDuplicates = new LeetCode82_deleteDuplicates();
        System.out.println("你的答案:");
        System.out.println("链表 : [1,2,3,3,4,4,5]  去除重复数字为 : " + ListUtil.printLinkedList(deleteDuplicates.deleteDuplicates(ListUtil.createLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5}))));
        System.out.println("链表 : [-1,0,0,0,0,3,3] 去除重复数字为 : " + ListUtil.printLinkedList(deleteDuplicates.deleteDuplicates(ListUtil.createLinkedList(new int[]{-1,0,0,0,0,3,3}))));
        System.out.println("------------------------->");
        System.out.println("正确答案:");
        System.out.println("链表 : [1,2,3,3,4,4,5]  去除重复数字为 : " + ListUtil.printLinkedList(deleteDuplicates.deleteDuplicatesV1(ListUtil.createLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5}))));
        System.out.println("链表 : [-1,0,0,0,0,3,3] 去除重复数字为 : " + ListUtil.printLinkedList(deleteDuplicates.deleteDuplicatesV2(ListUtil.createLinkedList(new int[]{-1, 0, 0, 0, 0, 3, 3}))));

    }
}
