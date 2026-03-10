# Java 算法题解

用 Java 刷算法题的代码仓库，主要涵盖 LeetCode 等平台的题目。

## 目录结构

```
.
├── src/
│   ├── array/          # 数组
│   ├── string/         # 字符串
│   ├── linkedlist/     # 链表
│   ├── tree/           # 树
│   ├── graph/          # 图
│   ├── dp/             # 动态规划
│   ├── backtracking/   # 回溯
│   ├── greedy/         # 贪心
│   ├── binarysearch/   # 二分查找
│   ├── sort/           # 排序
│   ├── stack/          # 栈
│   ├── queue/          # 队列
│   ├── heap/           # 堆
│   ├── math/           # 数学
│   └── other/          # 其他
└── README.md
```

## 命名规范

每道题建议以题号开头命名，例如：

- `_001_TwoSum.java`
- `_102_BinaryTreeLevelOrderTraversal.java`

## 常用算法标签

| 标签 | 说明 |
|------|------|
| 双指针 | Two Pointers |
| 滑动窗口 | Sliding Window |
| 前缀和 | Prefix Sum |
| 哈希表 | Hash Table |
| BFS/DFS | 广度/深度优先搜索 |
| 动态规划 | Dynamic Programming |
| 二分查找 | Binary Search |
| 并查集 | Union Find |
| 单调栈 | Monotonic Stack |

## 刷题进度

- 简单 Easy：1 题
- 中等 Medium：4 题
- 困难 Hard：0 题

## 题目列表

| 题号 | 题目 | 难度 | 标签 | 题解 | 完成日期 |
|------|------|------|------|------|----------|
| 105 | [从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | 中等 | 树、哈希表、递归 | [Java](src/tree/_105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java) | 2026-03-05 |
| 106 | [从中序与后序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | 中等 | 树、哈希表、递归 | [Java](src/tree/_106_ConstructBinaryTreeFromInorderAndPostorderTraversal.java) | 2026-03-05 |
| 112 | [路径总和](https://leetcode.cn/problems/path-sum/) | 简单 | 树、DFS、递归 | [Java](src/tree/_112_PathSum.java) | 2026-03-10 |
| 114 | [二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) | 中等 | 树、递归、链表 | [Java](src/tree/_114_FlattenBinaryTreeToLinkedList.java) | 2026-03-10 |
| 117 | [填充每个节点的下一个右侧节点指针 II](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/) | 中等 | 树、BFS | [Java](src/tree/_117_PopulatingNextRightPointersInEachNodeII.java) | 2026-03-05 |
| 144 | [二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/) | 简单 | 树、递归、DFS | [Java](src/tree/_144_BinaryTreePreorderTraversal.java) | 2026-03-10 |
