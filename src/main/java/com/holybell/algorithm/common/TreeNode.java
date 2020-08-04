package com.holybell.algorithm.common;

public class TreeNode {

    public int data;

    public TreeNode left;
    public TreeNode right;
    public int leftMaxDistance; // 左子树距离根节点的最大距离
    public int rightMaxDistance; // 右子树距离根节点的最大距离

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getLeftMaxDistance() {
        return leftMaxDistance;
    }

    public void setLeftMaxDistance(int leftMaxDistance) {
        this.leftMaxDistance = leftMaxDistance;
    }

    public int getRightMaxDistance() {
        return rightMaxDistance;
    }

    public void setRightMaxDistance(int rightMaxDistance) {
        this.rightMaxDistance = rightMaxDistance;
    }

    public TreeNode() {

    }

    public TreeNode(int data) {
        this.data = data;
    }
}
