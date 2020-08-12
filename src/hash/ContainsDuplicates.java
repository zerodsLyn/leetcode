package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zerodsLyn
 * created on 2020/8/12
 */
public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            if (numsSet.contains(num)) return true;
            numsSet.add(num);
        }

        return false;
    }
}
