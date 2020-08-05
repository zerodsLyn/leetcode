package stock;

/**
 * @author zerodsLyn create on 2020/08/05
 */
public class Q121_StockI {
    public int maxProfit(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) return 0;
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }

    public int maxProfitII(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) return 0;

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp_i_0 = Math.max(dp_i_1 + prices[i], dp_i_0);
            dp_i_1 = Math.max(-prices[i], dp_i_1);
        }

        return dp_i_0;
    }
}
