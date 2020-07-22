package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/7/22
 */
public class Q46_Permutations {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrace(nums, new LinkedList<>());
        return result;
    }

    public void backTrace(int[] nums, LinkedList<Integer> curNums) {
        if (curNums.size() == nums.length) {
            result.add(new LinkedList<>(curNums));
        }

        for (int num : nums) {
            if (!curNums.contains(num)) {
                curNums.add(num);
                backTrace(nums, curNums);
                curNums.removeLast();
            }
        }
    }
}
