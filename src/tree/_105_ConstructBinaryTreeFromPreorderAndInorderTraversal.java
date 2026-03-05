package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 思路：递归
 * - 前序遍历的第一个元素始终是当前子树的根节点
 * - 在中序遍历中找到根节点的位置，其左侧为左子树，右侧为右子树
 * - 用 HashMap 缓存中序遍历的值→下标，将查找根节点从 O(n) 降为 O(1)
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // 缓存中序遍历 值 -> 下标
    private Map<Integer, Integer> inorderIndex;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(0, 0, inorder.length - 1);
    }

    /**
     * @param preStart 当前子树根节点在 preorder 中的下标
     * @param inLeft   当前子树在 inorder 中的左边界
     * @param inRight  当前子树在 inorder 中的右边界
     */
    private TreeNode build(int preStart, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inMid = inorderIndex.get(rootVal);   // 根节点在中序中的位置
        int leftSize = inMid - inLeft;           // 左子树节点数

        root.left  = build(preStart + 1,             inLeft,    inMid - 1);
        root.right = build(preStart + leftSize + 1,  inMid + 1, inRight);

        return root;
    }
}
