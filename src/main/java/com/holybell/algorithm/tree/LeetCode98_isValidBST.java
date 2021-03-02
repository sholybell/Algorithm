package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.TreeUtil;

import java.util.Stack;

/**
 * 难度：中等
 * <p>
 * 判断一个二叉树是否为二叉搜索树
 * <p>
 * 1. 一棵二叉树满足左子节点小于父节点，右子节点大于父节点，而一颗二叉搜索树更加严格，左子树全部小于父节点，右子树全都大于父节点
 * 2. 一颗二叉搜索树的中序遍历一定是递增的
 */
public class LeetCode98_isValidBST {

    /**
     * 校验一颗二叉树是否为二叉搜索树
     *
     * @param root 根节点
     */
    private static boolean myIsValidBST(TreeNode root) {
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
     * 利用中序遍历升序
     */
    private static boolean isValidBSTV1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.getData() <= inorder)
                return false;
            inorder = root.getData();
            root = root.getRight();
        }
        return true;

    }

    /**
     * 递归：利用最大值最小值
     *
     * @param root 根节点
     */
    private static boolean isValidBSTV2(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 辅助方法
     * 上下界记得使用Long类型，因为树节点存储的数据是Integer，
     * 如果使用Integer.MAX_VALUE或者Integer.MIN_VALUE，在[2147483647]和[-2147483647]存在误判
     */
    private static boolean helper(TreeNode root, long lower, long upper) {

        // 一颗空树可以被认定为二叉搜索树
        if (root == null) {
            return true;
        }

        int val = root.val;
        // 当前节点必须处在(lower,upper)开区间之内，否则这棵树就不是二叉搜索树
        if (val <= lower || val >= upper) {
            return false;
        }

        // 分别判断左右子节点是否合法
        // 左子节点由于当前节点必定大于左子节点，因此左子节点的开区间变为(lower,root.val)
        // 右子节点由于当前节点必定小于右子节点，因此右子节点的开区间变为(root.val,upper)
        return helper(root.left, lower, val) && helper(root.right, val, upper);
    }

    public static void main(String[] args) {

        TreeNode root1 = TreeUtil.createBinaryTreeByArray(new Integer[]{2, 1, 3}, 0);
        TreeNode root2 = TreeUtil.createBinaryTreeByArray(new Integer[]{-2147483648}, 0);
        TreeNode root3 = TreeUtil.createBinaryTreeByArray(new Integer[]{2147483647}, 0);
        TreeNode root4 = TreeUtil.createBinaryTreeByArray(new Integer[]{5, 1, 4, null, null, 3, 6}, 0);

        System.out.println("你的答案:");
        System.out.println("[2,1,3]是二叉搜索树，验证结果:" + myIsValidBST(root1));
        System.out.println("[-2147483648]是二叉搜索树，验证结果:" + myIsValidBST(root2));
        System.out.println("[2147483647]是二叉搜索树，验证结果:" + myIsValidBST(root3));
        System.out.println("[5,1,4,null,null,3,6]是二叉搜索树，验证结果:" + myIsValidBST(root4));

        System.out.println("-------------------->");

        System.out.println("正确答案:");
        System.out.println("[2,1,3]是二叉搜索树，验证结果:" + isValidBSTV1(root1));
        System.out.println("[-2147483648]是二叉搜索树，验证结果:" + isValidBSTV2(root2));
        System.out.println("[2147483647]是二叉搜索树，验证结果:" + isValidBSTV2(root3));
        System.out.println("[5,1,4,null,null,3,6]是二叉搜索树，验证结果:" + isValidBSTV2(root4));
    }
}
