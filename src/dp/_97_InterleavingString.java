package dp;

/**
 * 97. Interleaving String
 * https://leetcode.cn/problems/interleaving-string/
 *
 * 思路：
 * dp[i][j] 表示 s1 前 i 个字符和 s2 前 j 个字符能否交错组成 s3 前 i+j 个字符。
 * 可以从 s1 取最后一个字符，也可以从 s2 取最后一个字符。
 *
 * 时间复杂度：O(m * n)
 * 空间复杂度：O(m * n)
 */
public class _97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if (m + n != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = s3.charAt(i + j - 1);

                boolean fromS1 = dp[i - 1][j] && s1.charAt(i - 1) == c;
                boolean fromS2 = dp[i][j - 1] && s2.charAt(j - 1) == c;

                dp[i][j] = fromS1 || fromS2;
            }
        }

        return dp[m][n];
    }
}
