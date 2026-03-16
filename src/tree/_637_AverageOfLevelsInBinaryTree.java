package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 *
 * Breadth-First Search (Level Order Traversal): We traverse the tree level by level.
 * For each level, we calculate the sum of all node values and divide by the number of nodes
 * to get the average value of that level.
 *
 * Time: O(n), where n is the number of nodes in the tree. Each node is processed exactly once.
 * Space: O(n), the maximum number of nodes in a level is O(n).
 */
public class _637_AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Double sum = 0.0;
            int num = size;
            while (size > 0) {
                TreeNode node = deque.poll();
                size--;
                sum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            Double aver = sum / num;
            ans.add(aver);
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
