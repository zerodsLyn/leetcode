package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * @author zerodsLyn create on 2020/03/02
 */
public class Q217_CombinationSumIII {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (9 * k < n) {
            return result;
        }
        List<Integer> curNums = new ArrayList<>();
        backtrack(k, n, 1,  curNums, 0);
        return result;
    }

    private void backtrack(int k, int n, int startPositiveNum, List<Integer> curNums, int sum) {
        if (curNums.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(curNums));
            }
            return;
        }

        for (int i = startPositiveNum; i <= n ; i++) {
            if (sum + 9 * (k - curNums.size()) < n) {
                break;
            }

            if (sum + i > n) {
                break;
            }

            curNums.add(i);
            backtrack(k, n, i + 1, curNums, sum + i);
            curNums.remove(curNums.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q217_CombinationSumIII().combinationSum3(3, 9));
    }
}
