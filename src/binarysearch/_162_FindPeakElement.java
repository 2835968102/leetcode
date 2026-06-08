package binarysearch;

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 *
 * 思路：
 * 1) 二分搜索中，比较 nums[mid] 与 nums[mid + 1]。
 * 2) 若 nums[mid] < nums[mid + 1]，说明右侧存在峰值，left = mid + 1。
 * 3) 否则峰值在左侧（包含 mid），right = mid。
 * 4) 最终 left == right 时即为任意一个峰值位置。
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class _162_FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
