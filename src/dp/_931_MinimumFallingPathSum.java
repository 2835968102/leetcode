package dp;

/**
 * 931. Minimum Falling Path Sum
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 *
 * 思路：
 * dp[i][j] 表示到达第 i 行第 j 列时的最小下降路径和。
 * 当前格子可以从正上方、左上方、右上方转移而来。
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */
public class _931_MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[i - 1][j];

                if (j > 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }

                if (j < n - 1) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }

                dp[i][j] = matrix[i][j] + min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }
}
