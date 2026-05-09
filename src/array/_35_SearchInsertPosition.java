package array;

/**
 * 35. 搜索插入位置
 * https://leetcode.cn/problems/search-insert-position/
 *
 * 思路：二分查找
 * - 在有序数组中查找第一个大于等于 target 的位置
 * - 如果所有元素都小于 target，则插入位置为 nums.length
 *
 * 时间复杂度：O(log n)
 * 空间复杂度：O(1)
 */
public class _35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = n;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
