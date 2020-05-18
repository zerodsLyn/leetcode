/**
 * @author zerodsLyn create on 2020/05/18
 */
public class Q152_MaxProductSubArray {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            int tmp= Math.max(Math.max(curNum, curMax * curNum), curMin * curNum);
            curMin = Math.min(Math.min(curNum, curMin * curNum), curMax * curNum);
            curMax = tmp;

            max = Math.max(max, curMax);
        }

        return max;
    }
}
