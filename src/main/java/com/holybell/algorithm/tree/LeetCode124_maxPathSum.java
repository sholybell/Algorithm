package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.TreeUtil;

/**
 * 难度:困难
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3]
 * 1
 * / \
 * 2   3
 * 输出：6
 * <p>
 * 示例 2：
 * 输入：[-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：42
 **/
public class LeetCode124_maxPathSum {

    private static int result = Integer.MIN_VALUE;


    private static int _maxPathSum(TreeNode root) {
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
     * 求非空二叉树的最大路径和
     *
     * @param root 根节点
     * @return 二叉树最大路径和
     */
    private static int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }

    private static int helper(TreeNode root) {
        // 当前要处理的节点为null，返回0
        if (root == null) {
            return 0;
        }

        // 联想二叉树的后续遍历，先遍历左子节点，再遍历右子节点，然后再做数据处理
        // 这里比较左右子树和最大路径和，大于等于0的才采纳，注意题意，路径最短只需要一个节点，也就说当所有节点都是负数的时候，最大负数节点本身构成最大路径和解!!!!
        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));

        // 记录当前节点考虑了左右子树的最大路径和和自己的值之后的最大值，与之前获得的最大值比较，取更大值
        // 注意与下面那行代码作区分，这里是以当前节点为路径之一，而不是当前节点作为路径结尾，因此这里把采用左子树和+右子树和+当前节点的值
        result = Math.max(leftSum + rightSum + root.data, result);

        // 记录以当前节点为路径结尾时最大路径和，因此只能考虑左右子树较大值+当前节点的值
        // 注意这里可能由于左右子树都是负数节点（被前面的操作取0），因此当前节点自身构成最大路径和的情况
        return Math.max(leftSum, rightSum) + root.data;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createBinaryTreeByArray(new Integer[]{-10, 9, 20, null, null, 15, 7}, 0);
        System.out.println("本次处理的二叉树:");
        TreeUtil.show(root);
        System.out.println("你的答案:");
        System.out.println(_maxPathSum(root));
        result = Integer.MIN_VALUE; // 重置
        System.out.println("--------------------------->");
        System.out.println("正确答案:");
        System.out.println(maxPathSum(root));
    }
}
