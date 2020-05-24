package binarysearch;

/**
 * @author zerodsLyn
 * created on 2020/5/24
 */
public class Q_RotateSeach2 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        int mid = (l + r) / 2;
        int curVal = nums[mid];
        // 如果单调，则直接二分
        if (nums[l] <= nums[r]) return binarysearch(nums, l, r, target);
        if (curVal == target) return mid;

        int result;
        // 中点在后半段
        if (curVal < nums[r]) {
            if (curVal < target && (result = binarysearch(nums, mid + 1, r, target)) != -1) {
                return result;
            }
            return search(nums, l, mid - 1, target);
        } else {
            // 中点在前半段
            if (curVal > target && (result = binarysearch(nums, l, mid - 1, target)) != -1) {
                return result;
            }
            return search(nums, mid + 1, r, target);
        }
    }

    private int binarysearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2 ;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 0));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 1));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 2));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 3));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 4));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 5));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 6));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 7));
        System.out.println(new Q_RotateSeach2().search(new int[] {4, 5, 6, 7, 0 ,1, 2}, 8));
        System.out.println(new Q_RotateSeach2().search(new int[] {1,3}, 0));
    }
}
