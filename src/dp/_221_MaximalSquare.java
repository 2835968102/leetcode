package dp;

/**
 * 221. Maximal Square
 * https://leetcode.cn/problems/maximal-square/
 *
 * 思路：
 * dp[i][j] 表示以 matrix[i - 1][j - 1] 为右下角的最大正方形边长。
 * 如果当前位置为 '1'，则边长由上、左、左上三个位置的最小值 + 1 得到。
 *
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 */
public class _221_MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    ) + 1;

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
