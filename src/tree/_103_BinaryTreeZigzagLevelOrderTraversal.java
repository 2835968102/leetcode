package tree;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 *
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 *
 * Approach 1: We use BFS to traverse level by level. For each alternating level, we reverse the order
 * by using a stack to reorder the nodes before adding to the queue for the next level.
 *
 * Time: O(n), all nodes are processed exactly once
 * Space: O(n), the maximum number of nodes in a level is O(n)
 *
 * Approach 2: Simpler BFS - we only reverse the current level's result when needed, children are
 * always added in normal order (left then right).
 *
 * Time: O(n), all nodes are processed exactly once
 * Space: O(n), the maximum number of nodes in a level is O(n)
 *
 * Approach 3: Use Deque to collect results - when traversing from right to left, we just add
 * elements to the front of the deque. This is the most clean approach.
 *
 * Time: O(n), all nodes are processed exactly once
 * Space: O(n), the maximum number of nodes in a level is O(n)
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {

    /**
     * Approach 1: Reorder next level nodes using stack
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        int rotate = 1;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> inList = new ArrayList<>();
            Stack<TreeNode> back = new Stack<>();
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                inList.add(node.val);
                size--;
                if (rotate == 1) {
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                } else {
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                }
            }
            while (!deque.isEmpty()) {
                TreeNode mid = deque.poll();
                back.push(mid);
            }
            while (!back.isEmpty()) {
                TreeNode mid = back.pop();
                deque.offer(mid);
            }

            rotate = 1 - rotate;
            ans.add(inList);
        }
        return ans;
    }

    /**
     * Approach 2: Only reverse current level values using stack, keep children order normal
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        int reverseFlag = 0;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> inList = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.poll();
                if (reverseFlag == 0) {
                    inList.add(node.val);
                } else {
                    stack.push(node);
                }
                size--;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            if (reverseFlag == 1) {
                while (!stack.isEmpty()) {
                    TreeNode mid = stack.pop();
                    inList.add(mid.val);
                }
            }

            reverseFlag = 1 - reverseFlag;
            ans.add(inList);
        }
        return ans;
    }

    /**
     * Approach 3: Use Deque to collect results, add to head or tail based on direction
     * This is LeetCode's official clean solution
     */
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
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
