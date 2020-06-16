package backtrack;

import java.util.*;

/**
 * @author zerodsLyn
 * created on 2020/6/16
 */
public class Q47_PermutationsII {
    Set<List<Integer>> result = new LinkedHashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        backTrace(new LinkedList<Integer>(), new HashSet<>(nums.length), nums);
        List<List<Integer>> listResult = new LinkedList<>();
        listResult.addAll(result);
        return listResult;
    }

    private void backTrace(LinkedList<Integer> singleNums, Set<Integer> indexes, int[] nums) {
        if (singleNums.size() == nums.length) {
            result.add(new LinkedList<>(singleNums));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!indexes.contains(i)) {
                indexes.add(i);
                singleNums.add(nums[i]);

                backTrace(singleNums, indexes, nums);
                indexes.remove(i);
                singleNums.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q47_PermutationsII().permuteUnique(new int[]{1, 1, 2, 3}));
    }
}
