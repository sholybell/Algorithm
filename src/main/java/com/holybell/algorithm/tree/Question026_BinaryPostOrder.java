package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;

/**
 * 难度：困难
 * <p>
 * 已知一棵二叉树的前序遍历、中序遍历，求它的后序遍历
 */
public class Question026_BinaryPostOrder {


    static class MyBinaryTree {

        // 当前二叉树根节点
        private TreeNode root;

        /**
         * 根据前序遍历、中序遍历构造完整的二叉树，同时为二叉树的根节点赋值
         *
         * @param preOrder 前序遍历数组
         * @param inOrder  中序遍历数组
         */
        public void initTree(int[] preOrder, int[] inOrder) {

        }

        /**
         * 递归方法，每个前序遍历、中序遍历可以拆分成更小的前序遍历和中序遍历进行解析
         *
         * @param preOrder      前序遍历数组（可能是其中的一部分）
         * @param preOrderStart 前序遍历数组开始坐标
         * @param preOrderEnd   前序遍历数组结束坐标
         * @param inOrder       中序遍历数组（可能是其中的一部分）
         * @param inOrderStart  中序遍历数组开始坐标
         * @param inOrderEnd    中序遍历数组结束坐标
         * @return 每次递归二叉树子树的根节点
         */
        public TreeNode initTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd) {

            return null;
        }

        /**
         * 查询指定数组在中序遍历中的位置
         *
         * @param inOrder 中序遍历
         * @param x       指定数字
         * @param begin   起始坐标
         * @param end     结束坐标
         * @return 数字所在下标
         */
        public int findIndexInArray(int[] inOrder, int x, int begin, int end) {

            return -1;
        }

        public void postOrder() {

        }

        // 后序遍历方法递归实现
        public void postOrder(TreeNode localRoot) {

        }

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

    static class BinaryTree {

        // 当前二叉树根节点
        private TreeNode root;

        /**
         * 根据前序遍历、中序遍历构造完整的二叉树，同时为二叉树的根节点赋值
         *
         * @param preOrder 前序遍历数组
         * @param inOrder  中序遍历数组
         */
        public void initTree(int[] preOrder, int[] inOrder) {
            root = initTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        }

        /**
         * 递归方法，每个前序遍历、中序遍历可以拆分成更小的前序遍历和中序遍历进行解析
         *
         * @param preOrder      前序遍历数组（可能是其中的一部分）
         * @param preOrderStart 前序遍历数组开始坐标
         * @param preOrderEnd   前序遍历数组结束坐标
         * @param inOrder       中序遍历数组（可能是其中的一部分）
         * @param inOrderStart  中序遍历数组开始坐标
         * @param inOrderEnd    中序遍历数组结束坐标
         * @return 每次递归二叉树子树的根节点
         */
        public TreeNode initTree(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd) {

            // 如果前序遍历、中序遍历的头尾节点异常，则无需继续递归
            // 头尾节点如果相等，还是需要递归一次因为一个节点也算是一棵二叉树，需要将它作为一次递归的二叉树头结点返回，因此次数使用大于判断
            if (preOrderStart > preOrderEnd || inOrderStart > inOrderEnd) {
                return null;
            }

            // 本次递归根节点即为前序遍历第一个元素
            int rootVal = preOrder[preOrderStart];
            TreeNode rootNode = new TreeNode(rootVal);

            // 计算根节点在中序遍历中相对本次递归中序遍历起始坐标偏移量，左右子数组即为本次递归的左右子树
            int rootInIndex = findIndexInArray(inOrder, rootVal, inOrderStart, inOrderEnd);
            int offset = rootInIndex - inOrderStart - 1;
            // 递归获取左子树的根节点
            TreeNode left = initTree(preOrder, preOrderStart + 1, preOrderStart + 1 + offset, inOrder, inOrderStart, inOrderStart + offset);
            // 递归获取右子树的根节点
            TreeNode right = initTree(preOrder, preOrderStart + 1 + 1 + offset, preOrderEnd, inOrder, rootInIndex + 1, inOrderEnd);

            // 将左右子树绑定到本次递归的根节点上
            rootNode.left = left;
            rootNode.right = right;
            return rootNode;
        }

        /**
         * 查询指定数组在中序遍历中的位置
         *
         * @param inOrder 中序遍历
         * @param x       指定数字
         * @param begin   起始坐标
         * @param end     结束坐标
         * @return 数字所在下标
         */
        public int findIndexInArray(int[] inOrder, int x, int begin, int end) {
            for (int i = begin; i <= end; i++) {
                if (inOrder[i] == x) {
                    return i;
                }
            }
            return -1;
        }

        public void postOrder() {
            postOrder(root);
        }

        // 后序遍历方法递归实现
        public void postOrder(TreeNode localRoot) {
            if (localRoot != null) {
                postOrder(localRoot.left);
                postOrder(localRoot.right);
                System.out.print(localRoot.data + " ");
            }
        }
    }

    public static void main(String[] args) {

        BinaryTree biTree = new BinaryTree();
        int[] preOrder = {1, 2, 4, 8, 9, 5, 10, 3, 6, 7};
        int[] inOrder = {8, 4, 9, 2, 10, 5, 1, 6, 3, 7};
        biTree.initTree(preOrder, inOrder);
        System.out.print("后序遍历(正解)：");
        biTree.postOrder();

        System.out.println();
        System.out.println("=================================");

        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.initTree(preOrder, inOrder);
        System.out.print("后序遍历(答题)：");
        myBinaryTree.postOrder();
    }
}
