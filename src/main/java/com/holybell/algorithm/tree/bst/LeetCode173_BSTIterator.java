package com.holybell.algorithm.tree.bst;

import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.TreeUtil;
import com.holybell.algorithm.tree.LeetCode94_inorderTraversal;

import java.util.*;

/**
 * 难度:中等
 * <p>
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * <p>
 * <p>
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出
 * 。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * <p>
 * <p>
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext
 * ", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();     返回 3
 * bSTIterator.next();     返回 7
 * bSTIterator.hasNext();  返回 True
 * bSTIterator.next();     返回 9
 * bSTIterator.hasNext();  返回 True
 * bSTIterator.next();     返回 15
 * bSTIterator.hasNext();  返回 True
 * bSTIterator.next();     返回 20
 * bSTIterator.hasNext();  返回 False
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目在范围 [1, 105] 内
 * 0 <= Node.val <= 106
 * 最多调用 105 次 hasNext 和 next 操作
 * <p>
 * <p>
 * 进阶：
 * 你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。
 * 其中 h 是树的高度。
 * <p>
 * Related Topics 栈 树 设计
 * <p>
 * {@link LeetCode98_isValidBST} 验证一颗二叉树是否为二叉搜索树
 * {@link LeetCode94_inorderTraversal} 二叉树中序遍历
 */
public class LeetCode173_BSTIterator {

    class BSTIterator {

        public BSTIterator(TreeNode root) {

        }

        public int next() {
            return -1;
        }

        public boolean hasNext() {
            return false;
        }
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
     * 本解法借鉴了二叉树的中序遍历，栈的方式
     * {@link LeetCode98_isValidBST}
     */
    class BSTIteratorV1 {

        private ListNode head;

        public BSTIteratorV1(TreeNode root) {

            // 树中节点的数目在范围 [1, 105] 内

            ListNode pre = new ListNode(-1);
            head = pre;

            // 仅有一个根节点
            if (root.left == null && root.right == null) {
                // 头结点指向根节点的值
                pre.next = new ListNode(root.val);

            } else { // 二叉搜索树不止一个节点

                Stack<TreeNode> stack = new Stack<>();

                while (root != null || !stack.isEmpty()) {

                    // 不断地添加左子节点
                    while (root != null) {
                        stack.push(root);
                        root = root.left;
                    }

                    // 弹出最后一个左子节点
                    TreeNode curNode = stack.pop();
                    // 将当前节点值接入pre后继节点
                    pre.next = new ListNode(curNode.val);
                    // 前继节点后移到当前节点
                    pre = pre.next;

                    root = curNode.right;
                }

            }
        }

        // 题目定义，可以假定每次调用next一定有next存在
        public int next() {
            // head此时为前继节点，返回当前节点值
            int val = head.next.val;
            // 前继节点后移
            head = head.next;
            return val;
        }

        public boolean hasNext() {
            return head.next != null;
        }
    }

    class ListNode {

        public int val;
        public ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, TreeNode treeNode) {
            this.val = val;
            this.next = new ListNode(treeNode.val);
        }
    }

    // --------------------------------------------------------------------

    class BSTIteratorV2 {
        private int idx;
        private List<Integer> arr;

        public BSTIteratorV2(TreeNode root) {
            idx = 0;
            arr = new ArrayList<>();
            inorderTraversal(root, arr);
        }

        public int next() {
            return arr.get(idx++);
        }

        public boolean hasNext() {
            return idx < arr.size();
        }

        private void inorderTraversal(TreeNode root, List<Integer> arr) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, arr);
            arr.add(root.val);
            inorderTraversal(root.right, arr);
        }
    }

    // --------------------------------------------------------------------

    /**
     * TODO 本解法类似V1解法，只是V1通过构造迭代器的时候创建了一个链表，而本解法直接使用栈存储中序遍历
     */
    class BSTIteratorV3 {
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIteratorV3(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        LeetCode173_BSTIterator bstIterator = new LeetCode173_BSTIterator();
        TreeNode root = TreeUtil.createBinaryTreeByArray(new Integer[]{7, 3, 15, null, null, 9, 20}, 0);
        System.out.println("二叉搜索树如下:");
        TreeUtil.show(root);
        System.out.println("你的答案:");
        System.out.println("----------------------------------------->");
        System.out.println("正确答案:");
        BSTIteratorV1 bstIterator1 = bstIterator.new BSTIteratorV1(root);
        System.out.println("执行next操作 : " + bstIterator1.next());
        System.out.println("执行next操作 : " + bstIterator1.next());
        System.out.println("执行hasNext操作 : " + bstIterator1.hasNext());
        System.out.println("执行next操作 : " + bstIterator1.next());
        System.out.println("执行hasNext操作 : " + bstIterator1.hasNext());
        System.out.println("执行next操作 : " + bstIterator1.next());
        System.out.println("执行hasNext操作 : " + bstIterator1.hasNext());
        System.out.println("执行next操作 : " + bstIterator1.next());
        System.out.println("执行hasNext操作 : " + bstIterator1.hasNext());
    }

}
