package backtrack;

import java.util.*;

/**
 * @author zerodsLyn
 * created on 2020/8/25
 */
public class Q491_IncreasingSubSequences {
    List<List<Integer>> result = new LinkedList<>();
    Set<List<Integer>> resultSet = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length < 2) return new LinkedList<>();
        brackTrace(new LinkedList<>(), nums, -1);
        return result;
    }

    private void brackTrace(LinkedList<Integer> singleRow, int[] nums, int lastIndex) {
        if (!resultSet.contains(singleRow) && singleRow.size() > 1) {
            List<Integer> copy = new LinkedList<>(singleRow);
            result.add(copy);
            resultSet.add(copy);
        }

        for (int i = lastIndex + 1; i < nums.length; i++) {
            if (singleRow.isEmpty() || nums[i] >= singleRow.getLast()) {
                singleRow.add(nums[i]);
                brackTrace(singleRow, nums, i);
                singleRow.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Q491_IncreasingSubSequences q491_increasingSubSequences = new Q491_IncreasingSubSequences();
        List<List<Integer>> subsequences /*= q491_increasingSubSequences.findSubsequences(new int[]{4,3,2,1});
        System.out.println(subsequences);
        subsequences = q491_increasingSubSequences.findSubsequences(new int[]{4, 6, 7, 7});
        System.out.println(subsequences);
        subsequences*/ = q491_increasingSubSequences.findSubsequences(new int[]{84,-48,-33,-34,-52,72,75,-12,72,-45});
        System.out.println(subsequences);
    }

}
