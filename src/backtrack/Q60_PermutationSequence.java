package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn create on 2020/06/03
 */
public class Q60_PermutationSequence {
    int count = 0;

    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> result = backtrace(new LinkedList<Integer>(), visited, n, k);
        for (int a : result) {
            stringBuilder.append(a);
        }

        return stringBuilder.toString();
    }

    private LinkedList<Integer> backtrace(LinkedList<Integer> result, boolean[] visited, int n, int k) {
        if (result.size() == n) {
            count++;
            return result;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;

                result.add(i);
                result = backtrace(result, visited, n, k);
                if (count == k) return result;
                result.removeLast();
                visited[i - 1] = false;
            }
        }

        return result;
    }
}
