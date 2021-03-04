package com.holybell.algorithm.tree.bfs;

import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.ListUtil;
import com.holybell.algorithm.common.util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 难度:中等
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 返回其层序遍历结果：
 * <p>
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * Related Topics 树 广度优先搜索
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class LeetCode102_levelOrder {

    private static List<List<Integer>> myLevelOrder(TreeNode root) {
        return new ArrayList<>();
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
     * BFS
     */
    private static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> layer = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(layer);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.createBinaryTreeByArray(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println("二叉树1如下:");
        TreeUtil.show(root1);
        System.out.println("你的答案:");
        System.out.println("二叉树1层序遍历:" + ListUtil.printNestedList(myLevelOrder(root1)));
        System.out.println("空树层序遍历:" + ListUtil.printNestedList(myLevelOrder(null)));
        System.out.println("正确答案:");
        System.out.println("二叉树1层序遍历:" + ListUtil.printNestedList(levelOrder(root1)));
        System.out.println("空树层序遍历:" + ListUtil.printNestedList(levelOrder(null)));

    }
}
