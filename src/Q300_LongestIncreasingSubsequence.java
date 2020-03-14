/**
 * @author gengchao05 create on 2020/03/14
 */
public class Q300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] maxLength = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxLength[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, maxLength[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 4, 3, 7, 101, 18, 19, 20}));
    }
}


