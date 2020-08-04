package offer;

import java.util.Arrays;

/**
 * @author zerodsLyn
 * created on 2020/8/4
 */
public class Q61_IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
            else {
                if (i > 0 && nums[i - 1] != 0) {
                    if (nums[i] == nums[i - 1]) return false;
                    zeroCount -= nums[i] - nums[i - 1] - 1;
                    if (zeroCount < 0) return false;
                }
            }
        }

        return true;
    }
}
