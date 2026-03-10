package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 * 思路：递归前序遍历
 * - 前序遍历顺序：根 → 左子树 → 右子树
 * - 递归访问每个节点，先记录当前节点值，再递归遍历左右子树
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)（递归调用栈）
 */
public class _144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 递归遍历
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);        // 访问根节点
        preorder(node.left, result);  // 遍历左子树
        preorder(node.right, result); // 遍历右子树
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
