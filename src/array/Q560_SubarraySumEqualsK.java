package array;

/**
 * @author zerodsLyn
 * created on 2020/5/15
 */
public class Q560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if (nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) result++;
            for (int j = i + 1; j < nums.length; j++) {
                int cur = nums[j];
                if (sum + cur == k) {
                    result++;
                }
                sum += cur;
            }
        }

        return result;
    }
}
