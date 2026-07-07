# Java 算法题解

用 Java 记录 LeetCode 等平台的算法题解。

## 目录结构

```text
.
├── src/
│   ├── array/          # 数组
│   ├── backtracking/   # 回溯
│   ├── binarysearch/   # 二分查找
│   ├── dp/             # 动态规划
│   ├── graph/          # 图
│   ├── heap/           # 堆
│   ├── linkedlist/     # 链表
│   ├── math/           # 数学
│   ├── string/         # 字符串
│   └── tree/           # 树
├── docs/
└── README.md
```

## 命名规范

每道题使用 `_<题号>_<英文题名>.java` 命名，例如：

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
| 回溯 | Backtracking |
| 位运算 | Bit Manipulation |

## 刷题进度

- 简单 Easy：18 题
- 中等 Medium：51 题
- 困难 Hard：11 题

## 题目列表

| 题号 | 题目 | 难度 | 标签 | 题解 | 完成日期 |
|------|------|------|------|------|----------|
| 4 | [两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays/) | 困难 | 二分查找 | [Java](src/binarysearch/_4_MedianOfTwoSortedArrays.java) | 2026-06-08 |
| 9 | [回文数](https://leetcode.cn/problems/palindrome-number/) | 简单 | 数学、字符串 | [Java](src/math/_9_PalindromeNumber.java) | 2026-06-11 |
| 17 | [电话号码的字母组合](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/) | 中等 | 回溯、哈希表 | [Java](src/backtracking/_17_LetterCombinationsOfAPhoneNumber.java) | 2026-03-25 |
| 22 | [括号生成](https://leetcode.cn/problems/generate-parentheses/) | 中等 | 回溯、字符串 | [Java](src/backtracking/_22_GenerateParentheses.java) | 2026-04-08 |
| 23 | [合并 K 个升序链表](https://leetcode.cn/problems/merge-k-sorted-lists/) | 困难 | 链表、堆、分治 | [Java](src/linkedlist/_23_MergeKSortedLists.java) | - |
| 33 | [搜索旋转排序数组](https://leetcode.cn/problems/search-in-rotated-sorted-array/) | 中等 | 二分查找 | [Java](src/binarysearch/_33_SearchInRotatedSortedArray.java) | 2026-06-08 |
| 34 | [在排序数组中查找元素的第一个和最后一个位置](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/) | 中等 | 二分查找 | [Java](src/binarysearch/_34_FindFirstAndLastPositionOfElementInSortedArray.java) | 2026-06-08 |
| 35 | [搜索插入位置](https://leetcode.cn/problems/search-insert-position/) | 简单 | 数组、二分查找 | [Java](src/array/_35_SearchInsertPosition.java) | 2026-05-09 |
| 39 | [组合总和](https://leetcode.cn/problems/combination-sum/) | 中等 | 回溯、DFS | [Java](src/backtracking/_39_CombinationSum.java) | 2026-04-02 |
| 46 | [全排列](https://leetcode.cn/problems/permutations/) | 中等 | 回溯、DFS | [Java](src/backtracking/_46_Permutations.java) | 2026-04-01 |
| 50 | [Pow(x, n)](https://leetcode.cn/problems/powx-n/) | 中等 | 数学、快速幂 | [Java](src/math/_50_PowxN.java) | 2026-06-11 |
| 52 | [N 皇后 II](https://leetcode.cn/problems/n-queens-ii/) | 困难 | 回溯、位运算 | [Java](src/backtracking/_52_NQueensII.java) | 2026-04-07 |
| 53 | [最大子数组和](https://leetcode.cn/problems/maximum-subarray/) | 中等 | 动态规划、分治 | [Java](src/array/_53_MaximumSubarray.java) | 2026-05-07 |
| 62 | [不同路径](https://leetcode.cn/problems/unique-paths/) | 中等 | 动态规划 | [Java](src/dp/_62_UniquePaths.java) | 2026-07-07 |
| 63 | [不同路径 II](https://leetcode.cn/problems/unique-paths-ii/) | 中等 | 动态规划 | [Java](src/dp/_63_UniquePathsII.java) | 2026-06-30 |
| 64 | [最小路径和](https://leetcode.cn/problems/minimum-path-sum/) | 中等 | 动态规划 | [Java](src/dp/_64_MinimumPathSum.java) | 2026-06-30 |
| 66 | [加一](https://leetcode.cn/problems/plus-one/) | 简单 | 数组 | [Java](src/math/_66_PlusOne.java) | 2026-06-11 |
| 67 | [二进制求和](https://leetcode.cn/problems/add-binary/) | 简单 | 字符串 | [Java](src/string/_67_AddBinary.java) | 2026-06-09 |
| 69 | [x 的平方根](https://leetcode.cn/problems/sqrtx/) | 简单 | 二分查找、数学 | [Java](src/math/_69_SqrtX.java) | 2026-06-11 |
| 70 | [爬楼梯](https://leetcode.cn/problems/climbing-stairs/) | 简单 | 动态规划 | [Java](src/math/_70_ClimbingStairs.java) | 2026-06-29 |
| 72 | [编辑距离](https://leetcode.cn/problems/edit-distance/) | 困难 | 动态规划 | [Java](src/dp/_72_EditDistance.java) | 2026-07-01 |
| 74 | [搜索二维矩阵](https://leetcode.cn/problems/search-a-2d-matrix/) | 中等 | 数组、矩阵、二分查找 | [Java](src/array/_74_SearchA2DMatrix.java) | 2026-05-09 |
| 77 | [组合](https://leetcode.cn/problems/combinations/) | 中等 | 回溯、DFS、剪枝 | [Java](src/backtracking/_77_Combinations.java) | 2026-04-01 |
| 79 | [单词搜索](https://leetcode.cn/problems/word-search/) | 中等 | 回溯、DFS、矩阵 | [Java](src/backtracking/_79_WordSearch.java) | 2026-04-09 |
| 97 | [交错字符串](https://leetcode.cn/problems/interleaving-string/) | 中等 | 动态规划 | [Java](src/dp/_97_InterleavingString.java) | 2026-07-01 |
| 98 | [验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/) | 中等 | 树、BST、中序遍历、栈 | [Java](src/tree/_98_ValidateBinarySearchTree.java) | 2026-03-17 |
| 102 | [二叉树的层序遍历](https://leetcode.cn/problems/binary-tree-level-order-traversal/) | 中等 | 树、BFS | [Java](src/tree/_102_BinaryTreeLevelOrderTraversal.java) | 2026-03-16 |
| 103 | [二叉树的锯齿形层序遍历](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/) | 中等 | 树、BFS | [Java](src/tree/_103_BinaryTreeZigzagLevelOrderTraversal.java) | 2026-03-17 |
| 105 | [从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | 中等 | 树、哈希表、递归 | [Java](src/tree/_105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java) | 2026-03-05 |
| 106 | [从中序与后序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | 中等 | 树、哈希表、递归 | [Java](src/tree/_106_ConstructBinaryTreeFromInorderAndPostorderTraversal.java) | 2026-03-05 |
| 108 | [将有序数组转换为二叉搜索树](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/) | 简单 | 树、BST、递归、分治 | [Java](src/tree/_108_ConvertSortedArrayToBinarySearchTree.java) | 2026-04-28 |
| 112 | [路径总和](https://leetcode.cn/problems/path-sum/) | 简单 | 树、DFS、递归 | [Java](src/tree/_112_PathSum.java) | 2026-03-10 |
| 114 | [二叉树展开为链表](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/) | 中等 | 树、递归、链表 | [Java](src/tree/_114_FlattenBinaryTreeToLinkedList.java) | 2026-03-10 |
| 117 | [填充每个节点的下一个右侧节点指针 II](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/) | 中等 | 树、BFS | [Java](src/tree/_117_PopulatingNextRightPointersInEachNodeII.java) | 2026-03-05 |
| 120 | [三角形最小路径和](https://leetcode.cn/problems/triangle/) | 中等 | 动态规划 | [Java](src/dp/_120_Triangle.java) | 2026-06-30 |
| 123 | [买卖股票的最佳时机 III](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/) | 困难 | 动态规划、状态机 | [Java](src/dp/_123_BestTimeToBuyAndSellStockIII.java) | 2026-07-01 |
| 124 | [二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) | 困难 | 树、DFS、递归 | [Java](src/tree/_124_BinaryTreeMaximumPathSum.java) | 2026-03-11 |
| 127 | [单词接龙](https://leetcode.cn/problems/word-ladder/) | 困难 | 图、BFS | [Java](src/graph/_127_WordLadder.java) | 2026-03-20 |
| 129 | [求根节点到叶节点数字之和](https://leetcode.cn/problems/sum-root-to-leaf-numbers/) | 中等 | 树、DFS、递归 | [Java](src/tree/_129_SumRootToLeafNumbers.java) | 2026-03-10 |
| 130 | [被围绕的区域](https://leetcode.cn/problems/surrounded-regions/) | 中等 | 图、DFS、网格 | [Java](src/graph/_130_SurroundedRegions.java) | 2026-03-18 |
| 133 | [克隆图](https://leetcode.cn/problems/clone-graph/) | 中等 | 图、DFS、哈希表 | [Java](src/graph/_133_CloneGraph.java) | 2026-03-18 |
| 136 | [只出现一次的数字](https://leetcode.cn/problems/single-number/) | 简单 | 位运算 | [Java](src/math/_136_SingleNumber.java) | 2026-06-10 |
| 137 | [只出现一次的数字 II](https://leetcode.cn/problems/single-number-ii/) | 中等 | 位运算 | [Java](src/math/_137_SingleNumberII.java) | 2026-06-11 |
| 139 | [单词拆分](https://leetcode.cn/problems/word-break/) | 中等 | 动态规划 | [Java](src/dp/_139_WordBreak.java) | 2026-06-29 |
| 144 | [二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal/) | 简单 | 树、递归、DFS | [Java](src/tree/_144_BinaryTreePreorderTraversal.java) | 2026-03-10 |
| 148 | [排序链表](https://leetcode.cn/problems/sort-list/) | 中等 | 链表、归并排序、快慢指针 | [Java](src/linkedlist/_148_SortList.java) | 2026-04-28 |
| 162 | [寻找峰值](https://leetcode.cn/problems/find-peak-element/) | 中等 | 二分查找 | [Java](src/binarysearch/_162_FindPeakElement.java) | 2026-06-08 |
| 172 | [阶乘后的零](https://leetcode.cn/problems/factorial-trailing-zeroes/) | 中等 | 数学 | [Java](src/math/_172_FactorialTrailingZeroes.java) | 2026-06-11 |
| 173 | [二叉搜索树迭代器](https://leetcode.cn/problems/binary-search-tree-iterator/) | 中等 | 树、栈、迭代器、BST | [Java](src/tree/_173_BinarySearchTreeIterator.java) | 2026-03-11 |
| 188 | [买卖股票的最佳时机 IV](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/) | 困难 | 动态规划、状态机 | [Java](src/dp/_188_BestTimeToBuyAndSellStockIV.java) | 2026-07-01 |
| 190 | [颠倒二进制位](https://leetcode.cn/problems/reverse-bits/) | 简单 | 位运算 | [Java](src/string/_190_ReverseBits.java) | 2026-06-09 |
| 191 | [位 1 的个数](https://leetcode.cn/problems/number-of-1-bits/) | 简单 | 位运算 | [Java](src/math/_191_NumberOf1Bits.java) | 2026-06-10 |
| 198 | [打家劫舍](https://leetcode.cn/problems/house-robber/) | 中等 | 动态规划 | [Java](src/array/_198_HouseRobber.java) | 2026-06-29 |
| 199 | [二叉树的右侧视图](https://leetcode.cn/problems/binary-tree-right-side-view/) | 中等 | 树、BFS | [Java](src/tree/_199_BinaryTreeRightSideView.java) | 2026-03-16 |
| 200 | [岛屿数量](https://leetcode.cn/problems/number-of-islands/) | 中等 | 图、DFS、网格 | [Java](src/graph/_200_NumberOfIslands.java) | 2026-03-17 |
| 201 | [数字范围按位与](https://leetcode.cn/problems/bitwise-and-of-numbers-range/) | 中等 | 位运算、二分查找 | [Java](src/binarysearch/_201_BitwiseAndOfNumbersRange.java) | 2026-06-11 |
| 207 | [课程表](https://leetcode.cn/problems/course-schedule/) | 中等 | 图、DFS、拓扑排序 | [Java](src/graph/_207_CourseSchedule.java) | 2026-03-18 |
| 208 | [实现 Trie（前缀树）](https://leetcode.cn/problems/implement-trie-prefix-tree/) | 中等 | 前缀树、设计 | [Java](src/tree/_208_ImplementTrie.java) | 2026-03-24 |
| 210 | [课程表 II](https://leetcode.cn/problems/course-schedule-ii/) | 中等 | 图、拓扑排序 | [Java](src/graph/_210_CourseScheduleII.java) | - |
| 211 | [添加与搜索单词](https://leetcode.cn/problems/design-add-and-search-words-data-structure/) | 中等 | 前缀树、DFS、设计 | [Java](src/tree/_211_WordDictionary.java) | 2026-03-24 |
| 212 | [单词搜索 II](https://leetcode.cn/problems/word-search-ii/) | 困难 | 前缀树、DFS、回溯 | [Java](src/tree/_212_WordSearchII.java) | 2026-03-25 |
| 215 | [数组中的第 K 个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array/) | 中等 | 堆、快速选择 | [Java](src/binarysearch/_215_KthLargestElementInAnArray.java) | 2026-06-08 |
| 221 | [最大正方形](https://leetcode.cn/problems/maximal-square/) | 中等 | 动态规划 | [Java](src/dp/_221_MaximalSquare.java) | 2026-07-01 |
| 222 | [完全二叉树的节点个数](https://leetcode.cn/problems/count-complete-tree-nodes/) | 简单 | 树、完全二叉树、二分 | [Java](src/tree/_222_CountCompleteTreeNodes.java) | 2026-03-11 |
| 230 | [二叉搜索树中第 K 小的元素](https://leetcode.cn/problems/kth-smallest-element-in-a-bst/) | 中等 | 树、BST、中序遍历、DFS | [Java](src/tree/_230_KthSmallestElementInABst.java) | 2026-03-17 |
| 236 | [二叉树的最近公共祖先](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/) | 中等 | 树、DFS、递归 | [Java](src/tree/_236_LowestCommonAncestorOfBinaryTree.java) | 2026-03-16 |
| 295 | [数据流的中位数](https://leetcode.cn/problems/find-median-from-data-stream/) | 困难 | 堆、设计 | [Java](src/heap/_295_FindMedianFromDataStream.java) | 2026-06-09 |
| 300 | [最长递增子序列](https://leetcode.cn/problems/longest-increasing-subsequence/) | 中等 | 动态规划 | [Java](src/dp/_300_LongestIncreasingSubsequence.java) | 2026-06-29 |
| 322 | [零钱兑换](https://leetcode.cn/problems/coin-change/) | 中等 | 动态规划、完全背包 | [Java](src/dp/_322_CoinChange.java) | 2026-06-29 |
| 373 | [查找和最小的 K 对数字](https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/) | 中等 | 堆 | [Java](src/heap/_373_FindKPairsWithSmallestSums.java) | 2026-06-09 |
| 433 | [最小基因变化](https://leetcode.cn/problems/minimum-genetic-mutation/) | 中等 | 图、BFS | [Java](src/graph/_433_MinimumGeneticMutation.java) | 2026-03-20 |
| 502 | [IPO](https://leetcode.cn/problems/ipo/) | 困难 | 堆、贪心 | [Java](src/heap/_502_IPO.java) | 2026-06-09 |
| 509 | [斐波那契数](https://leetcode.cn/problems/fibonacci-number/) | 简单 | 动态规划 | [Java](src/dp/_509_FibonacciNumber.java) | 2026-07-02 |
| 530 | [二叉搜索树的最小绝对差](https://leetcode.cn/problems/minimum-absolute-difference-in-bst/) | 简单 | 树、BST、中序遍历、DFS | [Java](src/tree/_530_MinimumAbsoluteDifferenceInBst.java) | 2026-03-17 |
| 637 | [二叉树的层平均值](https://leetcode.cn/problems/average-of-levels-in-binary-tree/) | 简单 | 树、BFS | [Java](src/tree/_637_AverageOfLevelsInBinaryTree.java) | 2026-03-16 |
| 740 | [删除并获得点数](https://leetcode.cn/problems/delete-and-earn/) | 中等 | 动态规划 | [Java](src/dp/_740_DeleteAndEarn.java) | 2026-07-07 |
| 746 | [最小花费爬楼梯](https://leetcode.cn/problems/min-cost-climbing-stairs/) | 简单 | 动态规划 | [Java](src/dp/_746_MinCostClimbingStairs.java) | 2026-07-02 |
| 918 | [环形子数组的最大和](https://leetcode.cn/problems/maximum-sum-circular-subarray/) | 中等 | 动态规划、前缀和 | [Java](src/array/_918_MaximumSumCircularSubarray.java) | 2026-05-07 |
| 931 | [下降路径最小和](https://leetcode.cn/problems/minimum-falling-path-sum/) | 中等 | 动态规划 | [Java](src/dp/_931_MinimumFallingPathSum.java) | 2026-07-07 |
| 3643 | [反转子矩阵](https://leetcode.cn/problems/reverse-submatrix/) | 简单 | 数组、矩阵 | [Java](src/array/_3643_ReverseSubmatrix.java) | - |
