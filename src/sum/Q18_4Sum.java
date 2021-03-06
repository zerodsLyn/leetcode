package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 * @author zerodsLyn create on 2020/02/28
 */
public class Q18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            int p = nums[i];

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int q = nums[j];

                int k = j + 1;
                int l = length - 1;
                while (k < l) {
                    boolean noK = false;
                    boolean noL = false;
                    int r = nums[k];
                    int s = nums[l];

                    int sum = p + q + r + s;
                    if (sum == target) {
                        List<Integer> result = new ArrayList<>();
                        result.add(p);
                        result.add(q);
                        result.add(r);
                        result.add(s);
                        resultList.add(result);
                        ++k;
                        --l;
                    } else if (sum > target) {
                        l--;
                        noK = true;
                    } else {
                        k++;
                        noL = true;
                    }

                    while (!noK && k < l && nums[k] == nums[k - 1]) {
                        k++;
                    }
                    while (!noL && k < l && nums[l] == nums[l + 1]) {
                        l--;
                    }
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Q18_4Sum().fourSum(new int[]{0, 4, -5, 2, -2, 4, 2, -1, 4}, 12));
    }
}
