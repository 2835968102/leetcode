package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 * https://leetcode.cn/problems/word-break/
 *
 * 思路：
 * dp[i] 表示 s[0..i-1] 是否可以被字典拼接出来。
 * 转移时枚举字典中的单词 word：
 * 如果 dp[i - len(word)] 为 true 且 s.substring(i - len, i) == word，
 * 那么 dp[i] = true。
 *
 * 时间复杂度：O(n * m * L)
 * 空间复杂度：O(n)
 */
public class _139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public boolean wordBreakBySplit(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
