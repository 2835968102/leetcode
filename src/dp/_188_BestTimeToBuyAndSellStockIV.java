package dp;

import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * 思路：
 * buy[i] 表示完成第 i 次买入后的最大收益。
 * sell[i] 表示完成第 i 次卖出后的最大收益。
 *
 * 时间复杂度：O(n * k)
 * 空间复杂度：O(k)
 */
public class _188_BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int i = 1; i < k + 1; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k];
    }
}
