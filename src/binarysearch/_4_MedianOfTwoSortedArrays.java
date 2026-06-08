package binarysearch;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 *
 * 给定两个升序数组 nums1 和 nums2，返回它们合并后数组的中位数。
 * 通过「找第 k 小」的二分递归实现 O(log(m+n))。
 *
 * 时间复杂度：O(log(m+n))
 * 空间复杂度：O(log(m+n))（递归栈深度）
 */
public class _4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        if (total % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            int left = findKth(nums1, 0, nums2, 0, total / 2);
            int right = findKth(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // nums1 用完了，只能从 nums2 里找
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }

        // nums2 用完了，只能从 nums1 里找
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }

        // 找第 1 小，就是两个当前元素较小的那个
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int half = k / 2;

        int newI = Math.min(i + half, nums1.length) - 1;
        int newJ = Math.min(j + half, nums2.length) - 1;

        int pivot1 = nums1[newI];
        int pivot2 = nums2[newJ];

        if (pivot1 <= pivot2) {
            // 丢掉 nums1[i...newI]
            int removed = newI - i + 1;
            return findKth(nums1, newI + 1, nums2, j, k - removed);
        } else {
            // 丢掉 nums2[j...newJ]
            int removed = newJ - j + 1;
            return findKth(nums1, i, nums2, newJ + 1, k - removed);
        }
    }
}
