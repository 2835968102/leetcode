package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    // 缓存中序遍历 值 -> 下标
    private Map<Integer, Integer> inorderIndex;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(inorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * @param preStart 当前子树根节点在 postorder 中的下标
     * @param inLeft   当前子树在 inorder 中的左边界
     * @param inRight  当前子树在 inorder 中的右边界
     */
    private TreeNode build(int preStart, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = postorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inMid = inorderIndex.get(rootVal);   // 根节点在中序中的位置
        int rightSize = inRight - inMid;          // 右子树节点数

        root.left  = build(preStart - rightSize - 1, inLeft,    inMid - 1);
        root.right = build(preStart - 1,             inMid + 1, inRight);

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
}
