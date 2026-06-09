package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 373. Find K Pairs with Smallest Sums
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/
 *
 * 两种解法：
 * 1) 带 visited 去重：每次取当前最小和组合 (i, j)，并尝试 (i+1, j)、(i, j+1)，避免重复入堆
 * 2) 不带 visited 的优化：初始放入 (nums1[i], nums2[0])，只沿着每个 i 的列向下推进
 */
public class _373_FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        return kSmallestPairsNoVisited(nums1, nums2, k);
    }

    // 写法1：带 visited 去重，直接从 (0,0) 启动
    public List<List<Integer>> kSmallestPairsWithVisited(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(java.util.Comparator.comparingInt(a -> a[0]));
        // 堆元素: [sum, i, j]
        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        while (!minHeap.isEmpty() && res.size() < k) {
            int[] cur = minHeap.poll();
            int i = cur[1];
            int j = cur[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length) {
                String keyDown = (i + 1) + "," + j;
                if (!visited.contains(keyDown)) {
                    minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                    visited.add(keyDown);
                }
            }

            if (j + 1 < nums2.length) {
                String keyRight = i + "," + (j + 1);
                if (!visited.contains(keyRight)) {
                    minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                    visited.add(keyRight);
                }
            }
        }

        return res;
    }

    // 写法2：不带 visited 的常见优化解法
    public List<List<Integer>> kSmallestPairsNoVisited(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(java.util.Comparator.comparingInt(a -> a[0]));
        // 堆元素: [sum, i, j]
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!minHeap.isEmpty() && res.size() < k) {
            int[] cur = minHeap.poll();
            int i = cur[1];
            int j = cur[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return res;
    }
}
