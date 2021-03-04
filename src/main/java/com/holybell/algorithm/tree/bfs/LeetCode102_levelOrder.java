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
     * <p>
     * 由于二叉树不存在环，因此不需要一个额外的visited集合记录遍历过的节点
     */
    private static List<List<Integer>> levelOrderV1(TreeNode root) {

        // 如果是空的二叉树，直接返回
        if (root == null) {
            return new ArrayList<>();
        }

        // 缓存最终层序遍历得列表
        List<List<Integer>> ans = new ArrayList<>();
        // 使用一个队列保存需要遍历的节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加第一层节点，即根节点
        queue.offer(root);

        // 每一次循环输出一层
        while (!queue.isEmpty()) {
            // 获取当前层需要获取几个元素
            int n = queue.size();
            // 保存本层遍历的节点
            List<Integer> layer = new LinkedList<>();
            // 根据前面获取的本层数量输出队列中的元素
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                // 判断队列弹出的节点，是否存在左右子节点，若存在加入度列，作为下一层循环遍历的节点使用
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

    // --------------------------------------------------------------------

    /**
     * DFS
     */
    private static List<List<Integer>> levelOrderV2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }

    private static void dfs(TreeNode node, List<List<Integer>> ans, int level) {

        //  当前节点为空，直接返回
        if (node == null) {
            return;
        }

        // 由于level从0开始，如果ans成员数量刚好等于level，那么说明ans需要再补充一个集合
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }

        // 将遍历的节点添加到相应层数的集合中
        ans.get(level).add(node.val);

        // 继续递归遍历左右子节点，层数+1
        dfs(node.left, ans, level + 1);
        dfs(node.right, ans, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.createBinaryTreeByArray(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println("二叉树1如下:");
        TreeUtil.show(root1);
        System.out.println("你的答案:");
        System.out.println("二叉树1层序遍历:" + ListUtil.printNestedList(myLevelOrder(root1)));
        System.out.println("空树层序遍历:" + ListUtil.printNestedList(myLevelOrder(null)));
        System.out.println("---------------------------------------------->");
        System.out.println("正确答案:");
        System.out.println("二叉树1层序遍历:" + ListUtil.printNestedList(levelOrderV2(root1)));
        System.out.println("空树层序遍历:" + ListUtil.printNestedList(levelOrderV1(null)));

    }
}
