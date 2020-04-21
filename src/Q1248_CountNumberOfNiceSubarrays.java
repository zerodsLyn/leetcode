/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * @author zerodsLyn
 * created on 2020/4/21
 */
public class Q1248_CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        int res = 0, sum = 0;
        for (int num: nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }
}
