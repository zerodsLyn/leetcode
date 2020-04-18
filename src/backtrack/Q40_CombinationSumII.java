import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author zerodsLyn create on 2020/03/02
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
