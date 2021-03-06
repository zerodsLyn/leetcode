package dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * @author zerodsLyn create on 2020/05/29
 */
public class Q198_Rob {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int lastLast = nums[0];
        int last = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = Math.max(Math.max(last, nums[i]), lastLast + nums[i]);
            lastLast = last;
            last = tmp;
        }

        return last;
    }
}
