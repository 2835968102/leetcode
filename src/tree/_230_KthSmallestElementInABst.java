package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 230. 二叉搜索树中第 K 小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 *
 * 思路：利用二叉搜索树的性质，中序遍历结果是递增有序的，遍历到第 k 个就是答案
 * - 中序遍历：左子树 → 根 → 右子树，遍历顺序就是从小到大
 * - 用一个计数器，每遍历一个节点计数器减 1，减到 0 就是第 k 小的元素
 *
 * Approach 1: 递归中序遍历
 * Time: O(k), 找到第 k 个就结束，实际只需要遍历前 k 个节点
 * Space: O(h), 递归调用栈深度 h 是树高，平均 O(log n), 最坏 O(n)
 *
 * Approach 2: 迭代中序遍历，手动维护栈
 * Time: O(k), 找到第 k 个就结束
 * Space: O(h), 手动栈的大小就是树高
 */
public class _230_KthSmallestElementInABst {

    int kthsmallest = 0;
    int result = 0;

    /**
     * Approach 1: 递归中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        kthsmallest = k;
        midorder(root);
        return result;
    }

    public void midorder(TreeNode node) {
        if (node == null) {
            return;
        }
        midorder(node.left);
        kthsmallest--;
        if (kthsmallest == 0) {
            result = node.val;
            return;
        }
        midorder(node.right);
    }

    /**
     * Approach 2: 迭代中序遍历，手动栈实现
     */
    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if (k == 0) break;
            root = root.right;
        }
        return root.val;
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
