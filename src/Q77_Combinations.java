import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
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
