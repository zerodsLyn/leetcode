import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author zerodsLyn create on 2019/04/25
 */
/*

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:
    Given array nums = [-1, 2, 1, -4], and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/
public class Q16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;

        Arrays.sort(nums);
        int closet = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length - 2; i++) {
            int indexL = i + 1;
            int indexR = length - 1;
            while (indexL < indexR) {
                int sum = nums[i] + nums[indexL] + nums[indexR];
                if (Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }

                if (sum > target) {
                    indexR--;
                } else if (sum < target) {
                    indexL++;
                } else {
                    return target;
                }
            }

        }

        return closet;
    }

    public static void main(String[] args) {
        System.out.println(new Q16_3SumClosest().threeSumClosest(new int[]{1, 2, 3, 5, 6, 90, 100}, 15));
        System.out.println(new Q16_3SumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(new Q16_3SumClosest().threeSumClosest(new int[]{1, 2, 3, 5, 6, 90, 100}, 15));
        System.out.println(new Q16_3SumClosest().threeSumClosest(new int[]{1, 2, 3, 5, 6, 90, 100}, 15));
    }
}
