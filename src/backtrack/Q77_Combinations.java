package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author zerodsLyn create on 2020/03/02
 */
public class Q77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Integer> curNums = new LinkedList<>();
        backtrack(n, k, result, curNums, 1);

        return result;
    }

    private void backtrack(int n, int k, List<List<Integer>> result, LinkedList<Integer> curNums, int startIndex) {
        if (curNums.size() == k) {
            result.add(new LinkedList<>(curNums));
            return;
        }

        for (int i = startIndex; (n - i + 1) + curNums.size() >= k; i++) {
            if (curNums.contains(i)) {
                continue;
            }

            if (!curNums.isEmpty()) {
                Integer last = curNums.peekLast();
                if (i < last) {
                    continue;
                }
            }

            curNums.add(i);
            backtrack(n, k, result, curNums, i + 1);
            curNums.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q77_Combinations().combine(4, 1));
        System.out.println(new Q77_Combinations().combine(4, 2));
        System.out.println(new Q77_Combinations().combine(4, 3));
        System.out.println(new Q77_Combinations().combine(4, 4));
    }
}
