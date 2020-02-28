/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * @author gengchao05 create on 2020/02/28
 */
public class Q167_TwoSumII_InputArraySorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int x = numbers[i];
            int y = numbers[j];

            int sum = x + y;
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q15_3Sum().threeSum_2(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        System.out.println(new Q15_3Sum().threeSum_2(new int[]{0,0,0,0,0}));
        System.out.println(new Q15_3Sum().threeSum_2(new int[]{9,9,7,-9,-7,0}));
    }
}
