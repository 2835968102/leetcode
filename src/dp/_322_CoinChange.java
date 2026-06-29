package dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.cn/problems/coin-change/
 *
 * 思路：
 * dp[i] 表示凑成金额 i 的最少硬币数。
 * 状态转移：dp[i] = min(dp[i], dp[i - coin] + 1)
 *
 * 时间复杂度：O(amount * coins.length)
 * 空间复杂度：O(amount)
 */
public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}
