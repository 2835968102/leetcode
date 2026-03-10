package tree;

/**
 * 112. Path Sum
 * https://leetcode.cn/problems/path-sum/
 *
 * Recursive DFS on root-to-leaf path sums.
 * Time: O(n), Space: O(h)
 */
public class _112_PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
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
