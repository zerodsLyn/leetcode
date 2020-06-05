/**
 * @author zerodsLyn create on 2020/05/26
 */
public class Q287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] == cur) {
                    return cur;
                }
            }
        }

        return -1;
    }
}
