package stock;

/**
 * @author zerodsLyn create on 2020/08/05
 */
public class Q122_StockII {
    public int maxProfit(int[] prices) {
        int len;
        if (prices == null || (len = prices.length) == 0) return 0;

        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }

        return dp_i_0;
    }
}
