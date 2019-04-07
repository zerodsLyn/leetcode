import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.Two Sum
 *      Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *      You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 *  Example:
 *      Given nums = [2, 7, 11, 15], target = 9,
 *
 *      Because nums[0] + nums[1] = 2 + 7 = 9,
 *
 *      return [0, 1].
 *
 * @author gengchao05
 * create on 2019/04/06
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{};
        Map<Integer, Integer> num2Index = new HashMap<Integer, Integer>();
        if (nums == null || nums.length < 1) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int nowNum = nums[i];
            Integer otherIndex = num2Index.get(target - nowNum);
            if (otherIndex != null && otherIndex != i) {
                return new int[] {otherIndex, i};
            }
            num2Index.put(nowNum, i);
        }

        return result;
    }

    public static void main(String[] args) {
        final int[] nums = new int[] {3,3};
        int target = 6;
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
    }
}
