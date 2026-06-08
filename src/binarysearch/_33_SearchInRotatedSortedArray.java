package binarysearch;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 *
 * 题意：
 * 在经过一次旋转的严格递增数组中，查找 target 的下标。
 *
 * 思路：
 * 1) 每次取 mid，先判断 nums[left] 是否小于等于 nums[mid]，可确认左半段有序。
 * 2) 若左半段有序，则判断 target 是否落在 [nums[left], nums[mid]) 区间内。
 *    - 在区间内：right = mid - 1
 *    - 不在区间内：left = mid + 1
 * 3) 否则右半段有序，判断 target 是否落在 (nums[mid], nums[right]]。
 *    - 在区间内：left = mid + 1
 *    - 不在区间内：right = mid - 1
 * 4) 找到返回下标，否则 -1。
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class _33_SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 左半部分有序
            if (nums[left] <= nums[mid]) {
                // target 在左半部分
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
