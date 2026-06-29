package array;

/**
 * 198. House Robber
 * https://leetcode.cn/problems/house-robber/
 *
 * 思路：
 * dp[i] 表示前 i 间房子的最大收益。
 * 状态转移：dp[i] = max(dp[i - 1], dp[i - 2] + nums[i - 1])
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class _198_HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
