package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/7/28
 */
public class Q15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int n = nums.length;
        if (n < 3) return result;

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (i == 0 || cur != nums[i - 1]) {
                int l = i + 1, r = n - 1;
                while (l < r) {
                    int left = nums[l];
                    if (l == i + 1 || left != nums[l - 1]) {
                        int right = nums[r];
                        if (r == n - 1 || right != nums[r + 1]) {
                            int sum = cur + left + right;
                            if (sum == 0) {
                                List<Integer> singleNums = new ArrayList<>(3);
                                singleNums.add(cur);
                                singleNums.add(left);
                                singleNums.add(right);
                                result.add(singleNums);
                                l++;r--;
                            } else if (sum > 0) {
                                r--;
                            } else {
                                l++;
                            }
                        } else {
                            r--;
                        }
                    } else {
                        l++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q15_ThreeSum().threeSum(new int [] {-1,0,1,2,-1,-4}));
    }
}
