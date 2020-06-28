/**
 * @author zerodsLyn
 * created on 2020/6/28
 */
public class Q209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int minLen = len + 1;
        int curSum = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            curSum += nums[i];
            while (curSum >= s) {
                minLen = Math.min(minLen, i - left + 1);
                curSum -= nums[left++];
            }
        }

        return minLen == len + 1 ? 0 : minLen;
    }
}
