package dp;

/**
 * @author zerodsLyn
 * created on 2020/7/10
 */
public class Q309_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int dp0 = -prices[0], dp1 = 0, dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp0 = Math.max(dp0, dp2 - prices[i]);
            int temp1 = dp0 + prices[i];
            int temp2 = Math.max(dp1, dp2);
            dp0 = temp0;
            dp1 = temp1;
            dp2 = temp2;
        }
        return Math.max(dp1, dp2);
    }
}
