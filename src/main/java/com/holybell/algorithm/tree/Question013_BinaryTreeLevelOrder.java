package com.holybell.algorithm.tree;


import com.alibaba.fastjson.JSONObject;
import com.holybell.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 难度:中等
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 作者：LeetCode
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 来源：力扣（LeetCode）著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Question013_BinaryTreeLevelOrder {


    // 用于深度优先算法全局结果集合
    private static List<List<Integer>> levels = new ArrayList<>();


    /**
     * 二叉树层序遍历
     *
     * @param root 根节点
     */
    private static List<List<Integer>> myLevelOrder(TreeNode root) {

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
     * 使用深度优选算法层序遍历二叉树
     *
     * @param root 根节点
     */
    private static List<List<Integer>> levelOrderV1(TreeNode root) {
        if (root == null)
            return levels;
        helper(root, 0);
        return levels;
    }

    private static void helper(TreeNode node, int level) {

        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
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

    /**
     * 使用广度优先算法层序遍历二叉树节点
     *
     * @param root 根节点
     */
    private static List<List<Integer>> levelOrderV2(TreeNode root) {

        // 最终结果的返回集合
        List<List<Integer>> levels = new LinkedList<>();

        // 校验二叉树是否为空
        if (root == null) {
            return null;
        }

        // 程序存储当前二叉树的节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队列
        queue.add(root);

        // 每次循环表示遍历二叉树的一层
        while (!queue.isEmpty()) {

            // 当前二叉树层的值集合
            List<Integer> cur = new ArrayList<>();
            levels.add(cur);

            int len = queue.size();
            // 遍历当前二叉树的一层节点，并将下一层节点存入队列中，以便外层循环开始下一轮循环
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                cur.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return levels;
    }

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println("是否输出:[[3],[9,20],[15,7]]:"
                + "[[3],[9,20],[15,7]]".equals(JSONObject.toJSONString(levelOrderV1(node3))));
        System.out.println("是否输出:[[3],[9,20],[15,7]]:"
                + "[[3],[9,20],[15,7]]".equals(JSONObject.toJSONString(levelOrderV2(node3))));
        System.out.println("---------->");
        levels.clear();
        System.out.println("是否输出:[[3],[9,20],[15,7]]:"
                + "[[3],[9,20],[15,7]]".equals(JSONObject.toJSONString(myLevelOrder(node3))));
    }
}
