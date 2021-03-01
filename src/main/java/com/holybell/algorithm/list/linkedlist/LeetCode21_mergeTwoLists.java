package com.holybell.algorithm.list.linkedlist;

import com.holybell.algorithm.common.ListNode;
import com.holybell.algorithm.common.util.ListUtil;

/**
 * 难度:简单
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * <p>
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * Related Topics 递归 链表
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LeetCode21_mergeTwoLists {

    private static ListNode myMergeTwoLists(ListNode l1, ListNode l2) {
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
     * 递归解法
     *
     * @param l1 链表1头结点
     * @param l2 链表2头结点
     */
    private static ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {

        // 如果l1或者l2链表为空，直接返回另一个链表
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 使用一个空节点指向l1的头结点
        ListNode dummy = new ListNode(0);
        dummy.next = l1;

        // 递归操作
        helper(l1, l2, dummy);

        return dummy.next;
    }

    /**
     * 递归操作
     * 以链表1位基准，链表2每个节点和链表1节点依次对比，如果链表2节点小于链表1节点，则将当前链表2节点插入到当前链表1节点和前继节点之间
     *
     * @param node1 链表1的节点
     * @param node2 链表2的节点
     * @param pre1  上次递归操作结束的链表1前继节点
     */
    private static void helper(ListNode node1, ListNode node2, ListNode pre1) {

        // 链表2比较结束，就不需要继续递归了
        if (node2 == null) {
            return;
        }

        // 链表1比较结束了，直接将剩下的链表2接入链表1的末尾即可
        if (node1 == null) {
            pre1.next = node2;
            return;
        }

        if (node1.val <= node2.val) {
            // 当前递归，链表1节点小于等于链表2节点，那么直接继续比较链表1的下一个节点，链表2节点保持不变
            // 下一次递归链表1的前继节点变为当前链表1节点node1
            helper(node1.next, node2, node1);
        } else {
            // 当前递归，链表1节点大于链表2节点，那么将当前链表2节点插入链表1前继节点和当前节点node1之间
            ListNode nextNode = node2.next;
            pre1.next = node2;
            node2.next = node1;
            // 下一轮递归时，链表1继续使用node1节点比较，链表2移动到下一个节点进行比较，链表1的前继节点转变为当前递归的nod2节点
            helper(node1, nextNode, node2);
        }
    }

    // ---------------------------------------------------------------------------

    /**
     * 迭代解法
     *
     * @param l1 链表1头结点
     * @param l2 链表2头结点
     */
    private static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = l1;

        ListNode pre = dummy;
        while (l1 != null) {
            while (l2 != null) {
                if (l1.val <= l2.val) {
                    break;
                } else {
                    // 将l2嵌入链表1的l1和前继节点之间
                    ListNode tmp = l2.next;
                    pre.next = l2;
                    l2.next = l1;
                    // 重要: 那么此时链表1的下一次循环的前继节点应该采用被插入的节点l2
                    pre = l2;
                    // 链表2前进一个节点继续与链表1的前继节点比较
                    l2 = tmp;
                }
            }
            pre = l1;
            // 链表1后挪一个节点
            l1 = l1.next;
        }

        if (l2 != null) {
            pre.next = l2;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = ListUtil.createLinkedList(new int[]{1, 2, 4});
        ListNode l2 = ListUtil.createLinkedList(new int[]{1, 3, 4});

        ListNode l3 = ListUtil.createLinkedList(new int[]{5});
        ListNode l4 = ListUtil.createLinkedList(new int[]{1, 2, 4});

        System.out.println("你的答案:");
        System.out.println("[1, 2, 4] 和 [1, 3, 4] 合并顺序 ==>     " + ListUtil.printLinkedList(myMergeTwoLists(l1, l2)));
        System.out.println("[5] 和 [1, 2, 4] 合并顺序 ==>     " + ListUtil.printLinkedList(myMergeTwoLists(l3, l4)));
        System.out.println();
        System.out.println("正确答案:");
        l1 = ListUtil.createLinkedList(new int[]{1, 2, 4});
        l2 = ListUtil.createLinkedList(new int[]{1, 3, 4});
        l3 = ListUtil.createLinkedList(new int[]{5});
        l4 = ListUtil.createLinkedList(new int[]{1, 2, 4});
        System.out.println("[1, 2, 4] 和 [1, 3, 4] 合并顺序 ==>     " + ListUtil.printLinkedList(mergeTwoListsV1(l1, l2)));
        System.out.println("[5] 和 [1, 2, 4] 合并顺序 ==>     " + ListUtil.printLinkedList(mergeTwoListsV2(l3, l4)));
    }
}
