package array;

/**
 * @author zerodsLyn
 * created on 2020/8/2
 */
public class Q88_MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int prevIndex = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums2[i];
            int index = findNextIndex(nums1, cur, prevIndex, m - 1);
            insertNum(nums1, cur, index, m++);
            prevIndex = index + 1;
        }
    }

    private int findNextIndex(int[] nums, int target, int start, int end) {
        if (end < 0) return 0;
        if (target >= nums[end]) return end + 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid + 1;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public void insertNum(int[] nums, int cur, int index, int curEnd) {
        while (curEnd > index) {
            nums[curEnd] = nums[curEnd - 1];
            curEnd--;
        }
        nums[index] = cur;
    }
}
