package doublepointer;

import java.util.Arrays;

/**
 * @author zerodsLyn
 * created on 2020/6/24
 */
public class Q16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        boolean init = true;
        int closest = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int left = nums[l];
                int right = nums[r];
                int sum = cur + left + right;

                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }

                if (init) {
                    closest = sum;
                    init = false;
                } else {
                    closest = Math.abs(sum - target) < Math.abs(closest - target) ?
                            sum : closest;
                }
            }
        }

        return closest;
    }
}
