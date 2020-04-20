import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author zerodsLyn create on 2020/03/07
 */
public class Q26_RemoveDuplicatesFromSortedArray {


    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (nums.length == 1){
            return 1;
        }

        int deleteNum = 0;

        int curVal = nums[nums.length - 1];
        int curIndex = nums.length - 2;
        while (curIndex >= 0) {
            if (nums[curIndex] == curVal) {
                for (int i = curIndex; i < nums.length - deleteNum - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                deleteNum++;
            } else  {
                curVal = nums[curIndex];
            }
            curIndex--;
        }

        return length - deleteNum;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (nums.length == 1){
            return 1;
        }

        int curDiffNum = 1;
        int num = nums[0];
        int j = 1;
        while (j < nums.length) {
            if (nums[j] == num) {
                j++;
            } else {
                nums[curDiffNum++] = nums[j];
                num = nums[j++];
            }
        }

        return curDiffNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates1(nums));
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates1(nums1));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[] {1,1,2};
        System.out.println(new Q26_RemoveDuplicatesFromSortedArray().removeDuplicates1(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
