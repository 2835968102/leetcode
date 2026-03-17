package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 *
 * 思路：利用二叉搜索树的性质，中序遍历结果应该是严格递增的序列
 * - 使用迭代中序遍历，手动维护栈
 * - 遍历过程中检查当前节点是否大于前一个节点，如果不是则不是 BST
 * - 用 double 保存前一个值，可以处理边界情况（节点值为 Integer.MIN_VALUE）
 *
 * Time: O(n), 最坏情况需要遍历所有节点
 * Space: O(h), 栈的大小等于树高，平均 O(log n), 最坏 O(n)
 */
public class _98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        double inorder = -Double.MAX_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;

            root = root.right;
        }
        return true;
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
