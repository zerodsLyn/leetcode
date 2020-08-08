package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zerodsLyn
 * created on 2020/6/6
 */
public class Q128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;

        Set<Integer> numsSet = new HashSet<>(len);
        for (int num : nums) numsSet.add(num);

        int result = 1;
        for (int num : nums) {
            if (numsSet.contains(num)) {
                numsSet.remove(num);
                int curNumToRemove = num;
                int curLength = 1;
                while (numsSet.contains(--curNumToRemove)) numsSet.remove(curNumToRemove);
                curLength += (num - curNumToRemove - 1);

                curNumToRemove = num;
                while (numsSet.contains(++curNumToRemove)) numsSet.remove(curNumToRemove);
                curLength += (curNumToRemove - num - 1);

                result = Math.max(result, curLength);
            }
        }

        return result;
    }
}
