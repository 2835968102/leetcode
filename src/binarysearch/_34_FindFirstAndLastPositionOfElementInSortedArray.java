package binarysearch;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 思路：
 * 1) 用两次二分查找，分别找最左和最右边界。
 * 2) 找左边界时：
 *    - 当 nums[mid] >= target 时，记录相等位置并向左缩小区间。
 *    - 否则向右缩小区间。
 * 3) 找右边界时：
 *    - 当 nums[mid] <= target 时，记录相等位置并向右缩小区间。
 *    - 否则向左缩小区间。
 * 4) 若不存在 target，两次查找均返回 -1。
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findLeft(nums, target);
        int rightIndex = findRight(nums, target);

        return new int[]{leftIndex, rightIndex};
    }

    // 找第一个等于 target 的位置
    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // 找最后一个等于 target 的位置
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
