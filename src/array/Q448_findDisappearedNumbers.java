package array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author gengchao05 create on 2020/07/24
 */
public class Q448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int idx = num - 1;
            while (i != idx && nums[idx] != num) {
                swap(nums, i, idx);
                num = nums[i];
                idx = num - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
