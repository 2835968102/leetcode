package dp;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 *
 * 思路：
 * dp[i] 表示以 nums[i] 结尾的最长递增子序列长度。
 * 转移：对于所有 j < i，如果 nums[j] < nums[i]，则 dp[i] = max(dp[i], dp[j] + 1)
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */
public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        int maxLen = 1;
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
