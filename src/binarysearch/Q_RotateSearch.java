package binarysearch;

/**
 * @author zerodsLyn
 * created on 2020/4/27
 */
public class Q_RotateSearch {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            // 中点在旋转点前
            if (nums[mid] >= nums[left]) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    int index = binarySearch(nums, target, left, mid - 1);
                    return index == -1 ?
                            search(nums, target, mid + 1, right) : index;
                }
            } else {
                // 中点在旋转点后
                if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    int index = binarySearch(nums, target, mid + 1, right);
                    return index == -1 ?
                            search(nums, target, left, mid - 1) : index;
                }
            }
        }

        return -1;
    }

    private int binarySearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target) low = mid + 1;
            else if (midVal > target) high = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q_RotateSearch().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 0));
        System.out.println(new Q_RotateSearch().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 3));
        System.out.println(new Q_RotateSearch().search(new int[] {1,3}, 0));
    }
}
