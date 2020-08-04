package offer;

/**
 * @author zerodsLyn
 * created on 2020/8/5
 */
public class Q13_CutRope {
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }

        return dp[n];
    }
}
