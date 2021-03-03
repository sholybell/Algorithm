package com.holybell.algorithm.tree;


import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.TreeUtil;

import java.util.*;

/**
 * 难度：中等
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LeetCode236_LowestCommonAncestor {

    private static TreeNode ans;


    private static TreeNode myLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

    // 解法1：

    private static TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        recurseTree(root, p, q);
        return ans;
    }

    /**
     * 通过递归，判断当前节点、当前节点的左子树、当前节点的右子树是否存在节点P、Q
     *
     * @param currentNode 当前节点
     * @param p           节点P
     * @param q           节点Q
     */
    private static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become True
        // 这里的ans是否会出现被多次覆盖结果得到最远公共祖先的情况，以下分析:
        // 1. 仅有在 (currentNode == p || currentNode == q) 时通过mid=1 才有可能递归回来的时候left\right =1
        // 2. 当p\q 两个节点分别为某个子树左右子树一个节点时，左右子树户通过mid=1 最终递归回来  left=1 right=1，此时ans得到第一个最近的祖先，但是继续递归回去这个节点的父节点
        // 只会出现left 或者 right =1 的情况，ans不会被覆盖
        // 3. 当p\q 两个节点为父子节点，那么会出现 left\right 二者之一为1，然后父节点mid=1，此时最近的祖先节点即为p或者q之一，在往上递归不会再出现left\right\mid两个为1的情况
        if (mid + left + right >= 2) {
            ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }


    // 解法2：

    /**
     * 使用一个Map缓存每个节点的父节点信息，
     * 将P或者Q其中一个节点的所有父节点都缓存到另一个Set集合中，
     * 然后从下往上遍历另一个节点的父节点是否在Set集合中
     * <p>
     * 本题解法思路和{@link LeetCode235_LowestCommonAncestor#lowestCommonAncestorV1(TreeNode, TreeNode, TreeNode)}
     *
     * @param root 根节点
     * @param p    节点P
     * @param q    节点Q
     */
    private static TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {

        // 如果根节点为null或者q、p之一，直接返回根节点
        if (root == null || p == root || q == root) {
            return root;
        }

        // Stack for tree traversal
        // 这个可以是stack，可以是queue，可以是deque，这里并没有先后顺序的考虑，只是存储下一个要解析子节点的节点
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.setLeft(node5);
        node3.setRight(node1);
        node5.setLeft(node6);
        node5.setRight(node2);
        node2.setLeft(node7);
        node2.setRight(node4);
        node1.setLeft(node0);
        node1.setRight(node8);

        System.out.println("二叉树如下:");
        TreeUtil.show(node3);

        System.out.println("你的答案:");
        System.out.println("Correct Answer is 3 :" + myLowestCommonAncestor(node3, node5, node1).val);
        System.out.println("Correct Answer is 5 :" + myLowestCommonAncestor(node3, node5, node4).val);
        System.out.println("----------------->");
        System.out.println("正确答案:");
        System.out.println("Correct Answer is 3 :" + lowestCommonAncestorV1(node3, node5, node1).val);
        System.out.println("Correct Answer is 5 :" + lowestCommonAncestorV1(node3, node5, node4).val);
        System.out.println("Correct Answer is 3 :" + lowestCommonAncestorV2(node3, node5, node1).val);
        System.out.println("Correct Answer is 5 :" + lowestCommonAncestorV2(node3, node5, node4).val);
    }
}
