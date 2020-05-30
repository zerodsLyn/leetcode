package dp;

/**
 * @author zerodsLyn
 * created on 2020/5/30
 */
public class Q_FindLongsetAccendingSubArray {
    public int findLengthOfLCIS(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;
        if (len == 1) return 1;

        int max = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
