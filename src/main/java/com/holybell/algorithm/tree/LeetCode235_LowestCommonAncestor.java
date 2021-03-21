package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.TreeUtil;

import java.util.*;

/**
 * 难度:简单
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * <p>
 * 示例 2:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * <p>
 * Related Topics 树
 */
public class LeetCode235_LowestCommonAncestor {

    /**
     * 查找二叉树中节点p和节点q的分支节点
     * <p>
     * 二叉搜索树符合每个节点都比所有左子节点大，比所有右子节点小
     *
     * @param root 当前要判断是否为分支节点的节点
     */
    private static TreeNode myLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return new TreeNode(0);
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

    private static TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 记录每一个节点的父节点信息
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        // 遍历其中一个节点p到达根节点的所有路径（包含自己）
        Set<TreeNode> ancestor = new HashSet<>();
        while (p != null) {
            ancestor.add(p);
            p = parentMap.get(p);
        }

        // 遍历q节点到根节点的路径，判断路径上的每个节点第一个出现在p的路径集合中的节点
        while (!ancestor.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }

    /**
     * 查找二叉树中节点p和节点q的分支节点
     * <p>
     * 二叉搜索树符合每个节点都比所有左子节点大，比所有右子节点小
     *
     * @param root 当前要判断是否为分支节点的节点
     */
    private static TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // 利用二叉搜索树特性 如果当前节点的值同时小于p和q的值，那么p、q的共同祖先应该从root的右子节点继续寻找
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorV2(root.right, p, q);
        }
        // 利用二叉搜索树特性 如果当前节点的值同时大于p和q的值，那么p、q的共同祖先应该从root的左子节点继续寻找
        else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorV2(root.left, p, q);
        } else {
            // 当前节点的值 刚好位于p、q节点之间(或者为其中一个节点)，划分了p和q，即为结果
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node6.left = node2;
        node6.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;

        System.out.println("二叉树如下:");
        TreeUtil.show(node6);
        System.out.println();
        System.out.println("你的答案:");
        System.out.println("节点2和节点4的最近公共祖先为:" + myLowestCommonAncestor(node6, node2, node4).val);
        System.out.println("节点2和节点8的最近公共祖先为:" + myLowestCommonAncestor(node6, node2, node8).val);
        System.out.println("------------------------------------>");
        System.out.println("正确答案:");
        System.out.println("节点2和节点4的最近公共祖先为:" + lowestCommonAncestorV2(node6, node2, node4).val);
        System.out.println("节点2和节点8的最近公共祖先为:" + lowestCommonAncestorV2(node6, node2, node8).val);
    }
}
