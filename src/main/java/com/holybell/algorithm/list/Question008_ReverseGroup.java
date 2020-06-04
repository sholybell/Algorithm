package com.holybell.algorithm.list;

import com.holybell.algorithm.common.ListNode;
import com.holybell.algorithm.common.Base;

import java.util.Stack;

/**
 * 难度：困难
 * <p>
 * 将链表分成k个一组，满足k个的子链表进行反转
 */
public class Question008_ReverseGroup extends Base {

    /**
     * K个一组，翻转链表
     *
     * @param head K个链表中的头结点
     * @param k    一组多少个
     */
    private static ListNode myReverseKGroupV1(ListNode head, int k) {

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
     * 利用栈的特性
     */
    private static ListNode reverseKGroupV1(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy; // 一开始p和dummy都指向头结点，之所以有了dummy之后还有一个p，是因为p表示的是正在操作的当前节点
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next; // tmp会循环到另一个k组的头结点
                count++;
            }
            if (count != k) {
                p.next = head;
                // System.out.print("==>" + head.val + " ");
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next; // 在此处，p指针先把头指针指向新的头结点，然后p指针重新指向下一个要被操作的节点
                // System.out.print("->" + p.val + " ");
            }
            // p.next = tmp; // 这个有什么意义?
            // System.out.print("-->" + tmp.val + " ");
            head = tmp; // 充值head节点到下一个k组合头结点
        }
        // System.out.println("!!!-->"+dummy.next.val);
        // print(dummy.next);
        return dummy.next;
    }

    /**
     * 定位到每段的最后一个节点，使用尾插法
     */
    private static ListNode reverseKGroupV2(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }
            // 如果和V1一样使用count!=k作为结束条件，会造成tail==null，然后进入下面的循环造成空指针异常，因为上一题是从K组头部操作，不会空指针，这个方法其实是从尾部开始，拿节点插入到尾部后面，因此需要用这个条件结束
            if (tail == null)
                break;
            ListNode head1 = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                // System.out.println("cur:" + cur.val);
                pre.next = cur.next;
                // System.out.println("pre.next:" + (pre.next == null ? "null" : pre.next.val));
                cur.next = tail.next;
                // System.out.println("cur.next:" + (cur.next == null ? "null" : cur.next.val));
                tail.next = cur;
                // System.out.println("tail.next:" + (tail.next == null ? "null" :
                // tail.next.val));
                // System.out.println("-------------->");
                // print(pre.next);
            }
            pre = head1;
            tail = head1;
            // System.out.println(head1.val);
        }
        return dummy.next;
    }

    /**
     * 递归
     */
    private static ListNode reverseKGroupV3(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        ListNode cur = head; // 这个cur会被循环到下一个K组的第一个头结点，然后作为回调函数的head入参，并且会被重置为逆序好之后的逆序头结点
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
            // System.out.println(cur.val);
        }
        // System.out.println("--------");
        if (count == k) {
            cur = reverseKGroupV3(cur, k);
            while (count != 0) { // 借助count控制循环的结束
                count--;
                ListNode tmp = head.next; // 存储下一个节点的位置
                head.next = cur; // 依次获取k组中的一个节点,指向已经拼接到下一个K组前面的节点，如果没有就是指向下一个k组的头结点
                cur = head; // 上一步已经将某个节点逆序到K组前，cur指向这个已经逆序好的最新节点位置
                head = tmp;
                // print(head);
            }
            head = cur; // 经过上面的循环之后，cur已经为逆序之后的第一个节点
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head = myReverseKGroupV1(node1, 3);
        System.out.println("V1: ");
        print(head);
    }
}
