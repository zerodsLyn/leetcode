/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author gengchao05 create on 2020/03/09
 */
public class Q121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int length;
        if (prices == null || (length = prices.length) <= 1) {
            return 0;
        }

        int max = 0;
        int min = prices[0];
        for (int j = 1; j < length; j++) {
            max = Math.max(max, prices[j] - min);
            if (prices[j] < min) {
                min = prices[j];
            }

        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q121_BestTimeToBuyAndSellStock().maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(new Q121_BestTimeToBuyAndSellStock().maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(new Q121_BestTimeToBuyAndSellStock().maxProfit(new int[] {2,1,2,1,0,1,2}));
    }
}
