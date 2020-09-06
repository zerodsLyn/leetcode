package hash;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @author zerodsLyn
 * created on 2020/9/6
 */
public class Q219_ContainsDuplicatesII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> num2Index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (num2Index.containsKey(nums[i])) {
                if (i - num2Index.get(nums[i]) <= k) {
                    return true;
                }
            }
            num2Index.put(nums[i], i);
        }

        return false;
    }
}
