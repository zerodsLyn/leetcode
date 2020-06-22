package binarysearch;

/**
 * @author zerodsLyn create on 2020/06/22
 */
public class Q35_SearchInsertPosition {
    boolean flag = false;

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int index = binarySearch(nums, target);
        if (flag) return index;

        return nums[index] < target ? index + 1 : index;
    }

    private int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == target) {
                flag = true;
                return mid;
            }
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        return lo;
    }

    public static void main(String[] args) {
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 1));
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 3));
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 4));
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 6));
        System.out.println(new Q35_SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 7));
    }
}
