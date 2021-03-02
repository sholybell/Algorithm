package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 难度:中等
 * <p>
 * 构造一颗二叉树，并输出其前序 、中序、后序、层次遍历
 */
public class Question050_BuildBinaryTree {

    public static class BinaryTree {

        private TreeNode root;

        private BinaryTree() {
            root = null;
        }

        /**
         * 根据给定数组构造一颗二叉树
         *
         * @param data 给定数组
         */
        private void myBuildTree(int[] data) {

        }

        /**
         * 将目标数字加入二叉树中
         *
         * @param data 目标数字
         */
        private void myInsert(int data) {

        }

        /**
         * 从根节点开始执行前序遍历
         */
        private void myPreOrder() {

        }

        /**
         * 执行前序遍历
         *
         * @param node 当前遍历节点
         */
        private void myPreOrder(TreeNode node) {

        }


        /**
         * 从根节点开始执行中序遍历
         */
        private void myInOrder() {

        }

        /**
         * 执行中序遍历
         *
         * @param node 当前遍历节点
         */
        private void myInOrder(TreeNode node) {

        }

        private void myPostOrder() {

        }

        /**
         * 从根节点开始执行后续遍历
         */
        private void myPostOrder(TreeNode node) {

        }

        /**
         * 执行层次遍历
         */
        private void myLayerTranverse() {

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
         * 根据给定数组构造一颗二叉树
         *
         * @param data 给定数组
         */
        private void buildTree(int[] data) {
            for (int num : data) {
                insert(num);
            }
        }

        /**
         * 将目标数字加入二叉树中
         *
         * @param data 目标数字
         */
        private void insert(int data) {

            // 如果根节点不存在，直接放到根节点上
            if (this.root == null) {
                this.root = new TreeNode(data);
            } else {    // 如果根节点存在，根据二叉树的规则查找到目标数字的父节点
                TreeNode newNode = new TreeNode(data);
                TreeNode curNode = root;
                while (true) {
                    if (curNode.val >= data) { // 当前节点大于等于目标数字
                        if (curNode.left == null) {
                            curNode.left = newNode;  // 如果不存在左子节点，那么直接放如目标数字
                            return;
                        } else {
                            curNode = curNode.left;
                        }
                    } else {    // 当前节点小于目标数字
                        if (curNode.right == null) {
                            curNode.right = newNode;  // 如果不存在右子节点，那么直接放如目标数字
                            return;
                        } else {
                            curNode = curNode.right;
                        }
                    }
                }
            }
        }

        /**
         * 从根节点开始执行前序遍历
         */
        private void preOrder() {
            preOrder(root);
        }

        /**
         * 执行前序遍历
         *
         * @param node 当前遍历节点
         */
        private void preOrder(TreeNode node) {
            if (node != null) {
                System.out.print(node.val + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }


        /**
         * 从根节点开始执行中序遍历
         */
        private void inOrder() {
            inOrder(root);
        }

        /**
         * 执行中序遍历
         *
         * @param node 当前遍历节点
         */
        private void inOrder(TreeNode node) {
            if (node != null) {
                inOrder(node.left);
                System.out.print(node.val + " ");
                inOrder(node.right);
            }
        }

        private void postOrder() {
            postOrder(root);
        }

        /**
         * 从根节点开始执行后续遍历
         */
        private void postOrder(TreeNode node) {
            if (node != null) {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(node.val + " ");
            }
        }

        /**
         * 执行层次遍历
         */
        private void layerTranverse() {
            // 此处使用BFS，广度优先算法

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                // 弹出队列中的第一个节点
                TreeNode curNode = queue.poll();
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }

        public static void main(String[] args) {
            BinaryTree biTree = new BinaryTree();
            int[] data = {2, 8, 7, 4, 9, 3, 1, 6, 7, 5};
            biTree.buildTree(data);
            System.out.print("正确答案中序遍历:");
            biTree.inOrder();
            System.out.println();
            System.out.print("正确答案前序遍历:");
            biTree.preOrder();
            System.out.println();
            System.out.print("正确答案后序遍历:");
            biTree.postOrder();
            System.out.println();
            System.out.print("正确答案层序遍历:");
            biTree.layerTranverse();
            System.out.println();

            System.out.println("------------------------------->");

            BinaryTree myBiTree = new BinaryTree();
            myBiTree.myBuildTree(data);
            System.out.print("本次答案中序遍历:");
            myBiTree.myInOrder();
            System.out.println();
            System.out.print("本次答案前序遍历:");
            myBiTree.myPreOrder();
            System.out.println();
            System.out.print("本次答案后序遍历:");
            myBiTree.myPostOrder();
            System.out.println();
            System.out.print("本次答案层序遍历:");
            myBiTree.myLayerTranverse();
            System.out.println();

        }
    }

}