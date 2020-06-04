package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;

import java.util.Stack;

/**
 * 难度：中等
 * <p>
 * 判断一个二叉树是否为二叉搜索树
 * <p>
 * 1. 一棵二叉树满足左子节点小于父节点，右子节点大于父节点，而一颗二叉搜索树更加严格，左子树全部小于父节点，右子树全都大于父节点
 * 2. 一颗二叉搜索树的中序遍历一定是递增的
 */
public class Question010_IsValidBST {


    /**
     * 校验一颗二叉树是否为二叉搜索树
     *
     * @param root 根节点
     */
    private static boolean myIsValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        int inOrder = Integer.MIN_VALUE;

        while (root != null && !stack.isEmpty()) {
            while (root != null) {
                stack.add(root.getLeft());
                root = root.getLeft();
            }

            root = stack.pop();
            int val = root.getData();
            if (val <= inOrder) {
                return false;
            }
            inOrder = root.getData();
            root = root.getRight();
        }
        return true;

//        return false;
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
        return helper(root, null, null);
    }

    /**
     * @param node  当前比较的节点
     * @param lower 上层节点中的最小节点
     * @param upper 上层节点中的最大节点
     */
    private static boolean helper(TreeNode node, Integer lower, Integer upper) {

        if (node == null)
            return true;

        int val = node.getData();

        if (lower != null && val <= lower)
            return false;

        if (upper != null && val >= upper)
            return false;

        if (!helper(node.getRight(), val, upper)) // 这么做其实是为了找从左子树中找到右子节点的值是否有大于根节点的
            return false;

        if (!helper(node.getLeft(), lower, val)) // 这么做其实是为了找从右子树中找到左子节点的值是否有小于根节点的
            return false;

        return true;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.setLeft(node2); // 根节点
        node4.setRight(node6);
        node2.setLeft(node1);
        node2.setRight(node3);
        node6.setLeft(node5);
        node6.setRight(node7);

        System.out.println("[2,1,3]是二叉搜索树，验证结果:" + isValidBSTV1(node4));
        System.out.println("[2,1,3]是二叉搜索树，验证结果:" + isValidBSTV2(node4));
        System.out.println("-------->");
        System.out.println("[2,1,3]是二叉搜索树，验证结果:" + myIsValidBST(node4));
    }
}
