/**
 * @author zerodsLyn
 * created on 2020/6/7
 */
public class Q_FindKthMaxElement {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return nums[sort(nums, 0, len - 1, len - k)];
    }

    private int sort(int[] nums, int l, int r, int index) {
        int pivot = nums[r];
        int leftIndex = l, rightIndex = r - 1;
        while (leftIndex <= rightIndex) {
            while (rightIndex >= leftIndex && nums[rightIndex] >= pivot)
                rightIndex--;
            while (rightIndex >= leftIndex && nums[leftIndex] < pivot)
                leftIndex++;

            if (leftIndex < rightIndex) {
                int tmp = nums[leftIndex];
                nums[leftIndex++] = nums[rightIndex];
                nums[rightIndex--] = tmp;
            }
        }

        int tmp = nums[leftIndex];
        nums[leftIndex] = pivot;
        nums[r] = tmp;

        if (leftIndex == index) return index;
        if (leftIndex < index) return sort(nums, leftIndex + 1, r, index);
        else return sort(nums, l, leftIndex - 1, index);
    }

    public static void main(String[] args) {
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,1,5,6,4}, 2));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,1,5,6,4}, 1));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,1,5,6,4}, 3));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,1,5,6,4}, 4));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,1,5,6,4}, 5));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,1,5,6,4}, 6));

        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 1));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 2));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 3));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 5));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 6));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 7));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 8));
        System.out.println(new Q_FindKthMaxElement().findKthLargest(new int [] {3,2,3,1,2,4,5,5,6}, 9));

    }
}
