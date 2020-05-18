/**
 * @author zerodsLyn
 * created on 2020/5/18
 */
public class Q_MaxProduct {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        int max = dp[0][0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1][0] < 0) {
                if (nums[i] < 0) {
                    dp[i][0] = dp[i - 1][0] * nums[i];
                    dp[i][1] = nums[i];
                } else {
                    dp[i][0] = nums[i];
                    dp[i][1] = dp[i - 1][0] * nums[i];
                }
            } else if (dp[i - 1][0] > 0) {
                if (dp[i - 1][1] < 0) {
                    if (nums[i] > 0) {
                        dp[i][0] = dp[i - 1][0] * nums[i];
                        dp[i][1] = dp[i - 1][1] * nums[i];
                    } else {
                        dp[i][0] = dp[i - 1][1] * nums[i];
                        dp[i][1] = dp[i - 1][0] * nums[i];
                    }
                    dp[i][0] = nums[i];
                    dp[i][1] = dp[i - 1][0] * nums[i];
                } else {
                    int result = nums[i] * dp[i - 1][0];
                    if (nums[i] > 0) {
                        dp[i][0] = result;
                        dp[i][1] = result;
                    } else {
                        dp[i][0] = nums[0];
                        dp[i][1] = result;
                    }
                }
            }

            max = Math.max(max, dp[i][0]);
        }

        return max;
    }
}
