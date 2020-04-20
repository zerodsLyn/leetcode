import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author zerodsLyn create on 2019/04/06
 */
public class Q1_TwoSum {
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
                return new int[]{otherIndex, i};
            }
            num2Index.put(nowNum, i);
        }

        return result;
    }

    public static void main(String[] args) {
        final int[] nums = new int[]{3, 3};
        int target = 6;
        System.out.println(Arrays.toString(new Q1_TwoSum().twoSum(nums, target)));
    }
}
