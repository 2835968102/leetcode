package dp;

/**
 * 64. Minimum Path Sum
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 * 思路：
 * dp[i][j] 表示从左上角走到 (i, j) 的最小路径和。
 * 状态转移：dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1])
 *
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 */
public class _64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
