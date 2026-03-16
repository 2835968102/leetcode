package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 *
 * Breadth-First Search: We traverse the tree level by level using a queue.
 * For each level, we:
 * 1. Get the size of the queue (number of nodes in current level)
 * 2. Process all nodes of the current level, adding their values to a list
 * 3. Enqueue their children for the next level
 * 4. Add the current level list to the result
 *
 * Time: O(n), all nodes are processed exactly once
 * Space: O(n), the maximum number of nodes in a level is O(n)
 */
public class _102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> inList = new ArrayList<>();
            while (size > 0) {
                TreeNode node = deque.poll();
                inList.add(node.val);
                size--;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            ans.add(inList);
        }

        return ans;
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
