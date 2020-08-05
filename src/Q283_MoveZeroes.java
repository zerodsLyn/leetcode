/**
 * @author zerodsLyn create on 2020/06/30
 */
public class Q283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur != 0) {
                nums[index++] = cur;
            }
        }

        for (int i = 0; i < count; i++) {
            nums[nums.length - i - 1] = 0;
        }
    }
}
