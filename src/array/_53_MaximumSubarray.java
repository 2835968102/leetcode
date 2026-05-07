package array;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 *
 * 思路 1：动态规划（Kadane 算法）
 * - pre 表示以当前元素结尾的连续子数组的最大和
 * - 状态转移：pre = max(pre + num, num)
 * - 遍历过程中维护全局最大值 maxAns
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 思路 2：分治
 * - iSum 表示区间和
 * - lSum 表示区间内以左端点开头的最大子数组和
 * - rSum 表示区间内以右端点结尾的最大子数组和
 * - mSum 表示区间内的最大子数组和
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(log n)
 */
public class _53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] nums, int left, int right) {
        if (left == right) {
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }

        int mid = (left + right) >> 1;
        Status leftSub = getInfo(nums, left, mid);
        Status rightSub = getInfo(nums, mid + 1, right);
        return pushUp(leftSub, rightSub);
    }

    private Status pushUp(Status leftSub, Status rightSub) {
        int iSum = leftSub.iSum + rightSub.iSum;
        int lSum = Math.max(leftSub.lSum, leftSub.iSum + rightSub.lSum);
        int rSum = Math.max(rightSub.rSum, rightSub.iSum + leftSub.rSum);
        int mSum = Math.max(Math.max(leftSub.mSum, rightSub.mSum), leftSub.rSum + rightSub.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    private static class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;

        Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
}
