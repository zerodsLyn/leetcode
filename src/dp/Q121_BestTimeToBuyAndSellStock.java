package dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author zerodsLyn create on 2020/03/09
 */
public class Q121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }

        // 这里动态规划的公式为f(n) = max{f(n-1), a[n] - min{a[0], a[1], ... , a[n-1]}}
        int min = prices[0];
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(prices[i], min);
        }

        return dp[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Q121_BestTimeToBuyAndSellStock().maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(new Q121_BestTimeToBuyAndSellStock().maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(new Q121_BestTimeToBuyAndSellStock().maxProfit(new int[] {2,1,2,1,0,1,2}));
    }
}
