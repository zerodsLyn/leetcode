import com.sun.tools.javadoc.Start;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author zerodsLyn create on 2020/02/24
 */
public class Q33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left == right && nums[left] != target) {
                return -1;
            }

            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            // 在后半部分旋转
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // 在前半部分旋转
            else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(new Q33_SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8));

    }
}
