package dp;

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * 思路：
 * 用四个状态记录最多两次交易过程中的最优收益：
 * buy1、sell1、buy2、sell2 分别表示第一次买入、第一次卖出、第二次买入、第二次卖出后的最大收益。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class _123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;

        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}
