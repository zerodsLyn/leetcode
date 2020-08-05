package array;

/**
 * @author zerodsLyn create on 2020/08/05
 */
public class Q209_MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int min = len + 1;
        int i = 0, j = 0;
        int curSum = nums[0];
        while (i < len && j < len) {
            if (curSum < s) {
                j++;
                if (j < len) {
                    curSum += nums[j];
                }
            } else {
                min = Math.min(min, j - i + 1);
                curSum -= nums[i++];
            }
        }

        return min == len + 1 ? 0 : min;
    }
}
