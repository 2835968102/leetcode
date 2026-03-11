package tree;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.cn/problems/binary-search-tree-iterator/
 *
 * Use a stack to simulate in-order traversal iteratively.
 * Push all left nodes on init and after each pop, push left spine of right subtree.
 * Time: O(1) amortized per next()/hasNext(), Space: O(h)
 */
public class _173_BinarySearchTreeIterator {

    static class BSTIterator {
        private final Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushAllLeft(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            pushAllLeft(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushAllLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
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
