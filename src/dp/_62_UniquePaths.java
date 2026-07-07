package dp;

/**
 * 62. Unique Paths
 * https://leetcode.cn/problems/unique-paths/
 *
 * 思路：
 * dp[i][j] 表示走到 (i, j) 的路径数。
 * 第一行和第一列都只有一种走法，其他位置来自上方和左方。
 *
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 */
public class _62_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
