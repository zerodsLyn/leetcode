package dp;

import java.util.List;

/**
 * @author zerodsLyn create on 2020/07/14
 */
public class Q120_TriangleII {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        if (size == 1) return dp[0];

        int minTotal = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            int curLen = triangle.get(i).size();
            for (int j = curLen - 1; j >= 0; j--) {
                int num = triangle.get(i).get(j);
                if (j == 0) {
                    dp[j] = dp[j] + num;
                } else if (j == curLen - 1) {
                    dp[j] = dp[j - 1] + num;
                } else {
                    dp[j] = num + Math.min(dp[j - 1], dp[j]);
                }

                if (i == size - 1) {
                    minTotal = Math.min(minTotal, dp[j]);
                }
            }
        }

        return minTotal;
    }
}
