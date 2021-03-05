package com.holybell.algorithm.tree.bfs_dfs;

import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 难度:简单
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class LeetCode111_minDepth {

    private static int myMinDepth(TreeNode root) {
        return -1;
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
     * 计算一颗二叉树的最小深度(BFS)
     *
     * @param root 二叉树根节点
     * @return 二叉树最小深度
     */
    private static int minDepthV1(TreeNode root) {

        // 根节点为null，深度为0
        if (root == null) {
            return 0;
        }

        // 根节点不存在左右子节点，最小深度为1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // BFS算法固定模板，借助一个FIFO的队列存储每一层元素节点
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 记录深度，由于根节点存在左右子节点，深度由1开始
        int depth = 1;

        // 当队列内部没有节点的时候遍历完毕
        while (!q.isEmpty()) {

            // 遍历二叉树的每一层，每遍历一层深度+1
            int size = q.size();    // q.size()不要直接放到for循环的结束条件，因为循环过程中不断地添加元素，会影响循环结果
            for (int i = 0; i < size; i++) {
                // 从队列头部弹出一个节点判断是否左右子节点都为null
                TreeNode cur = q.poll();
                // 当前节点不存在子节点，BFS算法搜索到的第一个不存在左右子节点的节点深度即为当前二叉树的最小深度，返回当前层数
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                // 将当前节点按照左子节点和右子节点的顺序，依次添加到队列q中（BFS算法的从左到右扫描），
                // 用于当for循环结束开启下一轮循环的时候，遍历下一层二叉树节点使用
                // 这里有个坏习惯，总是习惯性又写成了root节点
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }

            // 深度+1，表示上面for循环那一层没有左右子节点都为null的情况，至少要到下一层才能知道
            depth++;

        }

        return -1;
    }

    // --------------------------------------------------------------------

    private static int minDepth = Integer.MAX_VALUE;

    /**
     * 计算一颗二叉树的最小深度(DFS)
     */
    private static int minDepthV2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        // 重置深度
        minDepth = Integer.MAX_VALUE;

        dfs(root, 1);

        return minDepth;
    }

    private static void dfs(TreeNode node, int depth) {

        if (node.left == null && node.right == null) {
            // minDepth默认值为整型最大值，从每个叶子节点中取所有叶子节点中最小的深度
            minDepth = Math.min(minDepth, depth);
            return;
        }

        // 解析遍历当前节点的下一层节点
        if (node.left != null) {
            dfs(node.left, depth + 1);      // depth不要使用自增操作，否则将影响下面判断如果符合，则depth被改动
        }

        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
    }

    // --------------------------------------------------------------------

    /**
     * 同为DFS算法，不需要额外的全局变量
     */
    private static int minDepthV3(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = minDepthV3(root.left);
        int right = minDepthV3(root.right);

        // 切记，最小深度是根节点到达叶子节点最短的距离，而叶子节点是左右子树都为0的节点
        // 因此，如果某个节点左右子树有一个为0，以该节点为起始位置的最小深度应该选择非空子节点那边的子树深度+1，否则就是没有叶子节点，深度为1
        return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.createBinaryTreeByArray(new Integer[]{2, null, 3, null, 4, null, 5, null, 6}, 0);
        TreeNode root2 = TreeUtil.createBinaryTreeByArray(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        System.out.println("二叉树1如下:");
        TreeUtil.show(root1);
        System.out.println("二叉树2如下:");
        TreeUtil.show(root2);
        System.out.println("你的答案:");
        System.out.println("二叉树1最小深度:" + myMinDepth(root1));
        System.out.println("二叉树2最小深度:" + myMinDepth(root2));
        System.out.println("空树最小深度:" + myMinDepth(null));
        System.out.println("-------------------------------->");
        System.out.println("正确答案:");
        System.out.println("二叉树1最小深度:" + minDepthV1(root1));
        System.out.println("二叉树2最小深度:" + minDepthV2(root2));
        System.out.println("空树最小深度:" + minDepthV2(null));
    }
}
