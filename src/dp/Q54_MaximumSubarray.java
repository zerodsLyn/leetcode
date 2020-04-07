package dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author zerods
 * @version 1.0 2020/4/1
 */
public class Q54_MaximumSubarray {

    /**
     * 这里使用的是动态规划，因为是连续的序列，那么每个节点的最大值都必须加上自身
     * 所以要么是dp[i-1] + a[i], 要么是a[i]
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
