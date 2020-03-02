import java.util.*;

/**
 * @author gengchao05 create on 2019/06/27
 * <p>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of
 * nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 */
public class Q496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Map<Integer, Integer> num2Index = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            num2Index.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = findNextGreaterElement(nums2, num2Index.get(nums1[i]), nums1[i]);
        }

        return result;
    }

    public int[] nextGreaterElementWithStack(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> num2GreaterNum = new HashMap<>();

        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                num2GreaterNum.put(stack.pop(), i);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = num2GreaterNum.get(nums1[i]) == null ? -1 : num2GreaterNum.get(nums1[i]);
        }

        return result;
    }

    public int findNextGreaterElement(int[] nums, int index, int num) {
        for (int i = index + 1; i < nums.length; i++) {
            int curNum = nums[i];
            if (curNum > num) {
                return curNum;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

        /*int[] nums1 = new int[] {2,4};
        int[] nums2 = new int[] {1,2,3,4};*/

        int[] ints = new Q496_NextGreaterElementI().nextGreaterElementWithStack(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
