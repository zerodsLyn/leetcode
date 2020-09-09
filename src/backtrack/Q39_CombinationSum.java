package backtrack;

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
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(new LinkedList<>(), candidates, 0, target);
        return result;
    }

    private void backtrace(LinkedList<Integer> singleRow, int[] candidates, int curSum, int target) {
        if (curSum == target) {
            result.add(new LinkedList<>(singleRow));
            return;
        } else if (curSum > target) {
            return;
        }

        for (int num : candidates) {
            if (singleRow.size() > 0 && num < singleRow.getLast()) {
                continue;
            }
            singleRow.add(num);
            backtrace(singleRow, candidates, curSum + num, target);
            singleRow.removeLast();
        }
    }



    public static void main(String[] args) {
        new Q39_CombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
    }
}
