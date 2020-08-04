package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;

/**
 * 难度：中等
 * <p>
 * 求一颗二叉树到达左右子树叶子节点最大距离
 */
public class Question052_MaxDepthBinaryTreeV2 {

    public static class BinaryTree {

        // 二叉树根节点
        private static TreeNode root;
        // 二叉树最大深度
        private static Long maxLen = 0L;

        /**
         * 根据目标数组构造一颗二叉树
         *
         * @param a 目标数组
         */
        private void myBuildTree(int[] a) {

        }


        /**
         * 从目标节点开始计算二叉树最大深度
         *
         * @param node 目标节点
         */
        private void myFindMaxDistance(TreeNode node) {

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
         * 根据目标数组构造一颗二叉树
         *
         * @param a 目标数组
         */
        private void buildTree(int[] a) {
            for (int num : a) {
                TreeNode newNode = new TreeNode(num);
                // 如果还没有根节点，直接赋值给根节点
                if (root == null) {
                    root = newNode;
                } else {

                    TreeNode curNode = root;
                    while (true) {
                        // 要添加的节点 <= 当前节点，添加到左子树中
                        if (curNode.data >= num) {
                            // 不存在左子节点，直接挂到当前节点左边
                            if (curNode.left == null) {
                                curNode.left = newNode;
                                break;
                            } else {
                                // 继续到左子树判断挂载位置
                                curNode = curNode.left;
                            }
                        }
                        // 要添加的节点 > 当前节点，添加到左子树中
                        else {
                            if (curNode.right == null) {
                                curNode.right = newNode;
                                break;
                            } else {
                                // 继续到右子树判断挂载位置
                                curNode = curNode.right;
                            }
                        }
                    }
                }
            }
        }

        /**
         * 从目标节点开始计算二叉树最大深度
         *
         * @param node 目标节点
         */
        private void findMaxDistance(TreeNode node) {

            // 已经递归到叶子节点
            if (node == null) {
                return;
            }

            // 如果当前节点已经为叶子节点，记录左右子树最大深度为0
            // 这里不要直接return，因为可能左右子树一边到了叶子节点，但是另一边未到达
            if (node.left == null) {
                node.leftMaxDistance = 0;
            }
            if (node.right == null) {
                node.rightMaxDistance = 0;
            }

            if (node.left != null) {
                findMaxDistance(node.left);
            }
            if (node.right != null) {
                findMaxDistance(node.right);
            }

            // 计算当前节点的左右子树最大深度
            if (node.left != null) {
                node.leftMaxDistance = Math.max(node.left.leftMaxDistance, node.left.rightMaxDistance) + 1;
            }
            if (node.right != null) {
                node.rightMaxDistance = Math.max(node.right.leftMaxDistance, node.right.rightMaxDistance) + 1;
            }

            maxLen = Math.max(maxLen, node.leftMaxDistance + node.rightMaxDistance);
        }
    }

    public static void main(String[] args) {
        BinaryTree biTree = new BinaryTree();
        int[] data = {2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
        biTree.buildTree(data);
        biTree.findMaxDistance(BinaryTree.root);
        System.out.println("正确答案:" + biTree.maxLen);
        System.out.println("------------------------->");
        // 重置
        biTree.root = null;
        biTree.maxLen = 0L;
        biTree.myBuildTree(data);
        biTree.myFindMaxDistance(BinaryTree.root);
        System.out.println("本次答案:" + biTree.maxLen);
    }
}
