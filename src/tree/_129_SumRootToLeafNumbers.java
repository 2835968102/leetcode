package tree;

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 *
 * DFS accumulate path number.
 * Time: O(n), Space: O(h)
 */
public class _129_SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int current) {
        if (node.left == null && node.right == null) {
            return current;
        }
        int sum = 0;
        if (node.left != null) {
            sum += dfs(node.left, current * 10 + node.left.val);
        }
        if (node.right != null) {
            sum += dfs(node.right, current * 10 + node.right.val);
        }
        return sum;
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
