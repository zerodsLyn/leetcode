import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author zerodsLyn create on 2020/03/02
 */
public class Q39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>(0);
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> curNums = new LinkedList<>();;
        backtrack(result, candidates, target, curNums, 0, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] candidates, int target, LinkedList<Integer> curNums, int tempSum, int start) {
        // exit
        if (tempSum == target) {
            result.add(new LinkedList<>(curNums));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            // filter
            if (tempSum + num > target) {
                continue;
            }
            if (curNums.size() > 0) {
                if (num < curNums.get(curNums.size() - 1)) {
                    continue;
                }
            }
            curNums.add(num);
            backtrack(result, candidates, target, curNums, tempSum + num, start);
            curNums.removeLast();
        }
    }



    public static void main(String[] args) {
        new Q39_CombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
    }
}
