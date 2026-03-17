package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 *
 * 思路：利用二叉搜索树的性质，中序遍历得到递增有序数组，最小绝对差一定出现在相邻元素之间
 *
 * Approach 1: 先收集全部节点到数组，再遍历计算相邻差值
 * Time: O(n), 中序遍历 O(n) + 遍历相邻差值 O(n)
 * Space: O(n), 需要存储所有节点值，递归调用栈最坏 O(n)
 *
 * Approach 2: 空间优化，中序遍历过程中只记录前一个节点，直接计算差值
 * - 不需要存储整个数组，空间从 O(n) 优化到 O(h)，h 是递归栈深度
 * - 加入剪枝：当找到差值为 0 时，不可能更小了，提前返回
 * Time: O(n)（最坏），最好可以提前剪枝结束
 * Space: O(h), h 是树高，平均 O(log n), 最坏 O(n)
 */
public class _530_MinimumAbsoluteDifferenceInBst {

    /**
     * Approach 1: 收集全部节点到数组
     */
    public int getMinimumDifference(TreeNode root) {
        // 中序遍历结果
        List<Integer> result = new ArrayList<>();
        midorder(root, result);

        int min = Integer.MAX_VALUE;
        int len = result.size();
        for (int i = 1; i < len; i++) {
            int tmp = result.get(i) - result.get(i - 1);
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    public void midorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        midorder(node.left, result);
        result.add(node.val);
        midorder(node.right, result);
    }

    /**
     * Approach 2: 空间优化 + 剪枝，只记录前一个节点，遍历过程中计算差值
     */
    private int minDiff;
    private int prev;

    public int getMinimumDifference2(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = -1;
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null || minDiff == 0) {
            // 剪枝：已经找到最小可能差值 0，不需要继续遍历
            return;
        }
        inorder(node.left);
        if (prev != -1) {
            minDiff = Math.min(minDiff, node.val - prev);
            // 剪枝：差值不可能小于 0，如果已经等于 0，提前返回
            if (minDiff == 0) {
                return;
            }
        }
        prev = node.val;
        inorder(node.right);
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
