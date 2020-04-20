/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * @author zerodsLyn create on 2020/03/24
 */
public class Q_Massage {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int s_2 = nums[0];
        int s_1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(s_1, s_2 + nums[i]);
            s_2 = s_1;
            s_1 = max;
        }

        return s_1;
    }
}
