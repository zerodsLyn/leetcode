import java.util.*;

/**
 * @author gengchao05
 * create on 2019/04/24
 */
/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
    The solution set must not contain duplicate triplets.

Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
        [
          [-1, 0, 1],
          [-1, -1, 2]
        ]
*/
public class Q15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<List<Integer>>();
        }

        Set<List<Integer>> setSet = new HashSet<List<Integer>>();
        Map<Integer, List<Integer>> int2IndexSet = new HashMap<Integer, List<Integer>>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (int2IndexSet.get(nums[i]) == null) {
                int2IndexSet.put(nums[i], new ArrayList<Integer>());
            }
            int2IndexSet.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length - 2; i++) {
            Integer first = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                Integer second = nums[j];
                List<Integer> indexs = int2IndexSet.get(-(first + second));
                if (indexs != null && indexs.size() != 0  && indexs.get(indexs.size() - 1) > j) {
                    List result = new ArrayList();
                    result.add(first);
                    result.add(second);
                    result.add(-first-second);
                    setSet.add(result);
                }
                if (first + second >= 0) {
                    break;
                }
            }
            if (first >=  0) {
                break;
            }
        }

        return new ArrayList<List<Integer>>(setSet);

    }

    public static void main(String[] args) {
        System.out.println(new Q15_3Sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Q15_3Sum().threeSum(new int[]{0,0,0,0,0}));
        System.out.println(new Q15_3Sum().threeSum(new int[]{9,9,7,-9,-7,0}));
    }
}
