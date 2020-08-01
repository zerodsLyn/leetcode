package binarysearch;

/**
 * @author zerodsLyn
 * created on 2020/8/1
 */
public class Q33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len;
        if (nums == null || (len = nums.length) == 0) return -1;
        return search(nums, target, 0, len - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        int num = nums[mid];
        if (num == target) return mid;

            // 找大的
        else if (num < target) {
            // 这里尤其要注意前半段的判定有可能正好是第一个元素的情况
            if (num >= nums[start]) return search(nums, target, mid + 1, end);
            else {
                int idx = binarySearch(nums, target, mid + 1, end);
                return idx == - 1 ? search(nums, target, start, mid - 1) : idx;
            }
        }
        // 找小的
        else {
            if (num >= nums[start]) {
                int idx = binarySearch(nums, target, start, mid - 1);
                return idx == -1 ? search(nums, target, mid + 1, end) : idx;
            }
            else return search(nums, target, start, mid - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int midIndex = (start + end) /2;
            if (nums[midIndex] == target) return midIndex;
            else if (nums[midIndex] > target) end = midIndex - 1;
            else start = midIndex + 1;
        }
        return -1;
    }
}
