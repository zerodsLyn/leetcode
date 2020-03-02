import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author gengchao05 create on 2020/03/02
 */
public class Q40_CombinationSumII {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>(0);
        }

        Arrays.sort(candidates);
        List<Integer> curNums = new ArrayList<>();;
        backtrack(candidates, target, curNums, 0, 0);

        return result;
    }

    private void backtrack(int[] candidates, int target, List<Integer> curNums, int tempSum, int start) {
        // exit
        if (tempSum == target) {
            result.add(new ArrayList<>(curNums));
            return;
        }

        // flag here represents whether a number removed from curNum, if so, then next number should not equals last number
        boolean flag = false;
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            // only continue when a new start chosen and start number equals prev number
            if (i > 0 && num == candidates[i - 1] && (flag)) {
                continue;
            }
            // filter
            if (tempSum + num > target) {
                break;
            }

            curNums.add(num);
            flag = false;
            backtrack(candidates, target, curNums, tempSum + num, i + 1);
            curNums.remove(curNums.size() - 1);
            flag = true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q40_CombinationSumII().combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(new Q40_CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
