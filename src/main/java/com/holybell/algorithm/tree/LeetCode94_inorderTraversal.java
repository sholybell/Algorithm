package com.holybell.algorithm.tree;

import com.holybell.algorithm.common.TreeNode;
import com.holybell.algorithm.common.util.ListUtil;
import com.holybell.algorithm.common.util.TreeUtil;
import com.holybell.algorithm.tree.bst.LeetCode173_BSTIterator;
import com.holybell.algorithm.tree.bst.LeetCode98_isValidBST;

import java.util.*;

/**
 * 难度:中等
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Related Topics 栈 树 哈希表
 * <p>
 * {@link LeetCode173_BSTIterator}
 * {@link LeetCode98_isValidBST}
 */
public class LeetCode94_inorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        return Collections.emptyList();
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
     * 利用递归进行二叉树的中序遍历
     */
    public List<Integer> inorderTraversalV1(TreeNode root) {

        // 二叉树为空
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();

        // 仅有一个根节点，直接返回这个根节点的值
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }

        helper(root, ans);

        return ans;
    }

    private void helper(TreeNode node, List<Integer> inOrderList) {

        // 一次递归完结
        if (node == null) {
            return;
        }

        // 先递归左节点
        helper(node.left, inOrderList);
        // 中序遍历
        inOrderList.add(node.val);
        // 再递归右节点
        helper(node.right, inOrderList);
    }

    // --------------------------------------------------------------------

    /**
     * 利用栈对二叉树进行中序遍历
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {

        // 二叉树为空
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();

        // 二叉树仅有一个根节点
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }

        // 通过栈中序遍历二叉树
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }

        return ans;
    }

    public static void main(String[] args) {
        LeetCode94_inorderTraversal inorderTraversal = new LeetCode94_inorderTraversal();
        TreeNode root = TreeUtil.createBinaryTreeByArray(new Integer[]{7, 3, 15, null, null, 9, 20}, 0);
        System.out.println("二叉树如下:");
        TreeUtil.show(root);
        System.out.println("你的答案:");
        System.out.println("二叉树中序遍历 : " + Arrays.toString(inorderTraversal.inorderTraversal(root).toArray()));
        System.out.println("---------------------------------->");
        System.out.println("正确答案:");
        System.out.println("二叉树中序遍历 : " + Arrays.toString(inorderTraversal.inorderTraversalV1(root).toArray()));
    }
}
