package quicksort;

/**
 * @author zerodsLyn create on 2020/07/30
 */
public class Q215_FindKthLargestNum {
    public int findKthLargest(int[] nums, int k) {
        return nums[sort(nums, 0, nums.length - 1, nums.length - k)];
    }

    private int sort(int[] nums, int lIndex, int rIndex, int targetIndex) {
        int pivot = nums[rIndex];
        int l = lIndex, r = rIndex - 1;
        while (l <= r) {
            while (l <= r && nums[l] < pivot) l++;
            while (l <= r && nums[r] >= pivot) r--;
            if (l < r) swap(nums, l++, r--);
        }
        swap(nums, l, rIndex);

        if (l == targetIndex) return targetIndex;
        else if (l > targetIndex) return sort(nums, lIndex, l - 1, targetIndex);
        else return sort(nums, l + 1, rIndex, targetIndex);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
    }
}
