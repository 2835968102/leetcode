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

- 简单 Easy：4 题
- 中等 Medium：18 题
- 困难 Hard：1 题

## 题目列表

| 题号 | 题目 | 难度 | 标签 | 题解 | 完成日期 |
|------|------|------|------|------|----------|
| 98 | [验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/) | 中等 | 树、BST、中序遍历、栈 | [Java](src/tree/_98_ValidateBinarySearchTree.java) | 2026-03-17 |
| 102 | [二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/) | 中等 | 树、BFS | [Java](src/tree/_102_BinaryTreeLevelOrderTraversal.java) | 2026-03-16 |
| 103 | [二叉树的锯齿形层序遍历](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/) | 中等 | 树、BFS | [Java](src/tree/_103_BinaryTreeZigzagLevelOrderTraversal.java) | 2026-03-17 |
| 105 | [从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | 中等 | 树、哈希表、递归 | [Java](src/tree/_105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java) | 2026-03-05 |
| 106 | [从中序与后序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | 中等 | 树、哈希表、递归 | [Java](src/tree/_106_ConstructBinaryTreeFromInorderAndPostorderTraversal.java) | 2026-03-05 |
| 112 | [路径总和](https://leetcode.cn/problems/path-sum/) | 简单 | 树、DFS、递归 | [Java](src/tree/_112_PathSum.java) | 2026-03-10 |
| 114 | [二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) | 中等 | 树、递归、链表 | [Java](src/tree/_114_FlattenBinaryTreeToLinkedList.java) | 2026-03-10 |
| 117 | [填充每个节点的下一个右侧节点指针 II](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/) | 中等 | 树、BFS | [Java](src/tree/_117_PopulatingNextRightPointersInEachNodeII.java) | 2026-03-05 |
| 124 | [二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) | 困难 | 树、DFS、递归 | [Java](src/tree/_124_BinaryTreeMaximumPathSum.java) | 2026-03-11 |
| 127 | [单词接龙](https://leetcode.cn/problems/word-ladder/) | 中等 | 图、BFS | [Java](src/graph/_127_WordLadder.java) | 2026-03-20 |
| 129 | [求根节点到叶节点数字之和](https://leetcode.cn/problems/sum-root-to-leaf-numbers/) | 中等 | 树、DFS、递归 | [Java](src/tree/_129_SumRootToLeafNumbers.java) | 2026-03-10 |
| 130 | [被围绕的区域](https://leetcode.cn/problems/surrounded-regions/) | 中等 | 图、DFS、网格 | [Java](src/graph/_130_SurroundedRegions.java) | 2026-03-18 |
| 133 | [克隆图](https://leetcode.cn/problems/clone-graph/) | 中等 | 图、DFS、哈希表 | [Java](src/graph/_133_CloneGraph.java) | 2026-03-18 |
| 144 | [二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/) | 简单 | 树、递归、DFS | [Java](src/tree/_144_BinaryTreePreorderTraversal.java) | 2026-03-10 |
| 173 | [二叉搜索树迭代器](https://leetcode.cn/problems/binary-search-tree-iterator/) | 中等 | 树、栈、迭代器、BST | [Java](src/tree/_173_BinarySearchTreeIterator.java) | 2026-03-11 |
| 199 | [二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view/) | 中等 | 树、BFS | [Java](src/tree/_199_BinaryTreeRightSideView.java) | 2026-03-16 |
| 200 | [岛屿数量](https://leetcode.cn/problems/number-of-islands/) | 中等 | 图、DFS、网格 | [Java](src/graph/_200_NumberOfIslands.java) | 2026-03-17 |
| 207 | [课程表](https://leetcode.cn/problems/course-schedule/) | 中等 | 图、DFS、拓扑排序、环检测 | [Java](src/graph/_207_CourseSchedule.java) | 2026-03-18 |
| 222 | [完全二叉树的节点个数](https://leetcode.cn/problems/count-complete-tree-nodes/) | 中等 | 树、完全二叉树、二分 | [Java](src/tree/_222_CountCompleteTreeNodes.java) | 2026-03-11 |
| 230 | [二叉搜索树中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/) | 中等 | 树、BST、中序遍历、DFS | [Java](src/tree/_230_KthSmallestElementInABst.java) | 2026-03-17 |
| 236 | [二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/) | 中等 | 树、DFS、递归 | [Java](src/tree/_236_LowestCommonAncestorOfBinaryTree.java) | 2026-03-16 |
| 433 | [最小基因变化](https://leetcode.cn/problems/minimum-genetic-mutation/) | 中等 | 图、BFS | [Java](src/graph/_433_MinimumGeneticMutation.java) | 2026-03-20 |
| 530 | [二叉搜索树的最小绝对差](https://leetcode.cn/problems/minimum-absolute-difference-in-bst/) | 简单 | 树、BST、中序遍历、DFS | [Java](src/tree/_530_MinimumAbsoluteDifferenceInBst.java) | 2026-03-17 |
| 637 | [二叉树的层平均值](https://leetcode.cn/problems/average-of-levels-in-binary-tree/) | 简单 | 树、BFS | [Java](src/tree/_637_AverageOfLevelsInBinaryTree.java) | 2026-03-16 |
