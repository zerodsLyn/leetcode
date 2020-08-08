package array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * @author zerodsLyn create on 2020/03/09
 */
public class Q27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }

        int result = length;
        int i = 0;
        int j = length - 1;
        while (i <= j) {
            while (nums[j] == val) {
                j--;
                result--;
                if (j < i) {
                    return result;
                }
            }

            if (nums[i] == val && i != j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j--;
                result--;
            }

            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3,2,2,3};
        System.out.println(new Q27_RemoveElement().removeElement(a, 3));
        System.out.println(Arrays.toString(a));

        int[] b = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(new Q27_RemoveElement().removeElement(b, 6));
        System.out.println(Arrays.toString(b));

        int[] c = new int[] {2,2,3};
        System.out.println(new Q27_RemoveElement().removeElement(c, 2));
        System.out.println(Arrays.toString(c));
    }
}
