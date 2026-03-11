package tree;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 *
 * Post-order DFS: at each node, compute max gain from left/right subtrees
 * (clamped to 0), update global max with node + left + right, return node + max(left, right).
 * Time: O(n), Space: O(h)
 */
public class _124_BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftValue = Math.max(maxGain(node.left), 0);
        int rightValue = Math.max(maxGain(node.right), 0);

        int price = node.val + leftValue + rightValue;
        maxSum = Math.max(maxSum, price);

        return node.val + Math.max(leftValue, rightValue);
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
