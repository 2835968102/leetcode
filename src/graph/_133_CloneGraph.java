package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 133. 克隆图
 * https://leetcode.cn/problems/clone-graph/
 *
 * 思路：DFS + 哈希表记录已克隆节点
 * - 用 map 记录「原节点 -> 克隆节点」的映射，防止重复克隆和处理环
 * - 对当前节点创建克隆节点后，递归克隆每个邻居并加入邻居列表
 * - 若节点已在 map 中，直接返回克隆节点，避免死循环
 *
 * Time: O(V+E), V 为节点数，E 为边数，每个节点和边只处理一次
 * Space: O(V), map 存储所有节点的映射
 */
public class _133_CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public HashMap<Node, Node> map = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node cur = new Node(node.val);
        map.put(node, cur);
        for (Node neighbor : node.neighbors) {
            cur.neighbors.add(cloneGraph(neighbor));
        }
        return cur;
    }
}
