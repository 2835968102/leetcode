package binarysearch;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 *
 * 提供两种解法：
 * 1) 小顶堆：维护大小为 k 的最小堆，堆顶就是第 k 大元素。
 * 2) Quick Select：随机划分，按“倒序第 k 位”递归缩小区间，期望 O(n)。
 */
public class _215_KthLargestElementInAnArray {

    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        // 默认为 Quick Select 解法
        return findKthLargestByQuickSelect(nums, k);
    }

    public int findKthLargestByMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public int findKthLargestByQuickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int target = k - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == target) {
                return nums[pivotIndex];
            }

            if (pivotIndex > target) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, randomIndex, right);
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
