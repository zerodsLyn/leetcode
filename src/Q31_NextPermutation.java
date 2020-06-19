/**
 * @author gengchao05 create on 2020/06/18
 */
public class Q31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int maxIndex;
        if (nums == null || (maxIndex = nums.length - 1) == 0) return;

        for (int i = maxIndex - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = maxIndex;
                while (j > i && nums[j] <= nums[i]) {
                    j--;
                }

                swap(nums, i, j);
                reverse(nums, i + 1, maxIndex);
                return;
            }
        }

        reverse(nums, 0, maxIndex);
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi) swap(nums, lo++, hi--);
    }
}
