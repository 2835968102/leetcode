package tree;

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 *
 * Solution 1 (Optimal): Exploit complete binary tree property.
 * Walk leftmost and rightmost paths — if heights equal, it's a perfect subtree: return 2^h - 1.
 * Otherwise recurse on both children. Each recursive call reduces height by 1.
 * Time: O(log^2 n), Space: O(log n)
 *
 * Solution 2 (General): Plain post-order DFS, counts every node.
 * Time: O(n), Space: O(h)
 */
public class _222_CountCompleteTreeNodes {

    // Solution 1: complete binary tree optimization
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // left-height == right-height → perfect binary tree
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Solution 2: plain DFS
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes2(root.left) + countNodes2(root.right);
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
