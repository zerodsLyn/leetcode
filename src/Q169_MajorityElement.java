import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * @author gengchao05 create on 2020/03/13
 */
public class Q169_MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            int curNum;
            if (num2Count.containsKey(num)) {
                curNum = num2Count.get(num) + 1;
            } else {
                curNum = 1;
            }

            if (curNum >= nums.length / 2) {
                return num;
            }
            num2Count.put(num, curNum);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q169_MajorityElement().majorityElement1(new int[] {3,2,3}));
    }
}
