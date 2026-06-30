package dp;

import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.cn/problems/triangle/
 *
 * 思路：
 * 自底向上做 DP，dp[j] 表示当前行位置 j 到底部的最小路径和。
 * 转移：dp[j] = triangle[i][j] + min(dp[j], dp[j + 1])
 *
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */
public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
