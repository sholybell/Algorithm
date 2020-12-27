package com.holybell.algorithm.list.linkedlist;

import com.holybell.algorithm.common.ListNode;
import com.holybell.algorithm.common.util.ListUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 难度:简单
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0开始）。 如果 pos 是-1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 示例 1：
 * 输入：head=[3,2,0,-4],pos=1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head=[1,2],pos=0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head=[1],pos=-1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 提示：
 * 链表中节点的数目范围是[0,104]
 * -105<=Node.val<=105
 * pos 为-1或者链表中的一个有效索引 。
 */
public class LeetCode141_hasCycle {

    private static boolean _hasCycle(ListNode head) {
        return false;
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
     * 判断一个链表是否存在一个环
     * 空间复杂度O(1)
     *
     * @param head 链表头节点
     */
    private static boolean hasCycle(ListNode head) {

        // 若头指针为空，肯定不存在环
        if (head == null) {
            return false;
        }

        // 定义快慢指针，快指针一次走2步，慢指针一次走1步，若存在环，则两个指针最终肯定会在一个节点上相遇
        ListNode fast = head, slow = head;

        // 注意这个循环条件，由于fast指针一次走两步，因此应该判断其是否遇到空指针问题
        // 这里主要有两个空指针要校验:
        // 由于fast有fast.next.next的操作，因此fast不能为null，fast.next不能为null!!!!!
        while (fast != null && fast.next != null) {

            // 慢指针一次走一步，快指针一次走两步
            slow = slow.next;
            fast = fast.next.next;

            // 一定要令两个指针先走再比较，否则两个指针刚开始都在头结点上一定相等
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 如果不要求O(1)空间复杂度，可以借助一个Set遍历链表判断是否出现重复的节点
     *
     * @param head 链表头结点
     */
    private static boolean hasCycleV2(ListNode head) {

        // 若头指针为空，肯定不存在环
        if (head == null) {
            return false;
        }

        Set<ListNode> nodeCache = new HashSet<>();
        while (head != null) {
            // 第一个发现重复的节点，同时也是链表环的起点!!!!!
            if (!nodeCache.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode head1 = ListUtil.createCycleLinkedList(new int[]{1, 2}, -1);
        ListNode head2 = ListUtil.createCycleLinkedList(new int[]{3, 2, 0, -4}, 1);
        System.out.println("你的答案:");
        System.out.println(_hasCycle(head1));
        System.out.println(_hasCycle(head1));
        System.out.println("---------------------------->");
        System.out.println("正确答案:");
        System.out.println(hasCycle(head1));
        System.out.println(hasCycle(head2));
    }
}