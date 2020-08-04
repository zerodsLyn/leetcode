package dp;

/**
 * @author zerodsLyn
 * created on 2020/7/22
 */
public class Q322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int prevI = i - coin;
                if (prevI >= 0 && dp[prevI] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[prevI] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Q322_CoinChange().coinChange(new int[] {2,5,10,1}, 27));
    }
}
