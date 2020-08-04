package binarysearch;

/**
 * @author zerodsLyn
 * created on 2020/8/4
 */
public class Q704_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int num = nums[mid];
            if (num == target) return mid;
            else if (num > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
