package tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * 思路：BFS 层序遍历
 * - 每层遍历时用 last 记录上一个节点，依次连接 last.next = 当前节点
 * - BFS 天然保证同层节点按从左到右的顺序入队，next 指向不会出错
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class _117_PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left, right, next;
        public Node(int val) { this.val = val; }
    }
}
