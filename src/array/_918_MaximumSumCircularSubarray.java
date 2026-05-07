package array;

/**
 * 918. 环形子数组的最大和
 * https://leetcode.cn/problems/maximum-sum-circular-subarray/
 *
 * 思路：前缀最大值 + Kadane
 * - 先用 Kadane 求不跨环的最大子数组和
 * - leftMax[i] 表示区间 [0, i] 内前缀和的最大值
 * - 再从右向左枚举后缀和，与左侧最大前缀和拼接，求跨环的最大子数组和
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class _918_MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];

        int leftSum = nums[0];
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i - 1]);
        }
        return res;
    }
}
