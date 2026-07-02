package dp;

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 *
 * 思路：
 * 用两个变量滚动维护 dp[i - 2] 和 dp[i - 1]。
 * 状态转移：dp[i] = cost[i] + min(dp[i - 2], dp[i - 1])
 * 最终答案是最后两步中的较小值。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class _746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int a = cost[0];
        int b = cost[1];

        for (int i = 2; i < n; i++) {
            int cur = cost[i] + Math.min(a, b);
            a = b;
            b = cur;
        }

        return Math.min(a, b);
    }
}
