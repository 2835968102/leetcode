package dp;

/**
 * 740. Delete and Earn
 * https://leetcode.cn/problems/delete-and-earn/
 *
 * 思路：
 * 先把每个数字 x 的总贡献累加到 sum[x]。
 * 之后问题转化为打家劫舍：选择 i 就不能选择 i - 1 和 i + 1。
 *
 * 时间复杂度：O(n + max(nums))
 * 空间复杂度：O(max(nums))
 */
public class _740_DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] sum = new int[max + 1];

        for (int x : nums) {
            sum[x] += x;
        }

        if (max == 0) {
            return 0;
        }
        if (max == 1) {
            return sum[1];
        }

        int[] dp = new int[max + 1];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }

        return dp[max];
    }

    public int deleteAndEarnOptimized(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] sum = new int[max + 1];
        for (int x : nums) {
            sum[x] += x;
        }

        if (max == 0) {
            return 0;
        }

        int pre2 = 0;
        int pre1 = sum[1];

        for (int i = 2; i <= max; i++) {
            int cur = Math.max(pre1, pre2 + sum[i]);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}
