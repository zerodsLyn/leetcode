/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Q215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        return partition(nums, 0, length - 1, length - k + 1);
    }

    private int partition(int[] nums, int p, int r, int k) {
        int pivotIndex = p;
        int pivot = nums[r];
        for (int i = p; i < r; i++) {
            if (nums[i] < pivot) {
                if (i == pivotIndex) {
                    pivotIndex++;
                } else {
                    int tmp = nums[i];
                    nums[i] = nums[pivotIndex];
                    nums[pivotIndex++] = tmp;
                }
            }
        }

        int tmp = nums[pivotIndex];
        nums[pivotIndex] = pivot;
        nums[r] = tmp;

        if (pivotIndex == k - 1) {
            return nums[pivotIndex];
        } else if (pivotIndex > k - 1) {
            return partition(nums, p,  pivotIndex - 1, k);
        } else {
            return partition(nums, pivotIndex + 1, r, k);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new Q215_KthLargestElementInAnArray().findKthLargest(nums, 2));
        nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new Q215_KthLargestElementInAnArray().findKthLargest(nums, 4));
    }
}
