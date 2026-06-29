package math;

/**
 * 70. Climbing Stairs
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * 思路：斐波那契递推
 * dp[i] = dp[i - 1] + dp[i - 2]
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int prev2 = 1;
        int prev1 = 2;
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
