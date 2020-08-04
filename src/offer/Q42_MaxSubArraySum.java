package offer;

/**
 * @author zerodsLyn
 * created on 2020/8/4
 */
public class Q42_MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;

        int max = Integer.MIN_VALUE;
        int[] dp = new int[len];
        dp[0] = nums[0];
        max = Math.max(max, dp[0]);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
