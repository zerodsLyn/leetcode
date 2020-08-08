package dp;

/**
 * @author zerodsLyn create on 2020/03/14
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

    public int lengthOfLIS1(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        // 该数组中每个元素存的是当前最长子序列中尾元素最小的值
        // 例如： i = 2 代表长度为3的最长子序列中尾元素最小的子序列
        int[] longestNums = new int[nums.length];
        int res = 0;
        longestNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > longestNums[res]) {
                longestNums[++res] = nums[i];
            } else {
                longestNums[findProperIndex1(nums[i], longestNums, res)] = nums[i];
            }
        }

        return res + 1;
    }

    /**
     * 顺序查找
     * @param target
     * @param nums
     * @param endIndex
     * @return
     */
    private int findProperIndex(int target, int[] nums, int endIndex) {
        for (int i = 0; i <= endIndex; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 二分查找
     * @param target
     * @param nums
     * @param endIndex
     * @return
     */
    public int findProperIndex1(int target, int[] nums, int endIndex) {
        int left = 0;
        int right = endIndex;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

//        System.out.println(new dp.Q300_LongestIncreasingSubsequence().lengthOfLIS1(new int[]{2,2}));
//        System.out.println(new dp.Q300_LongestIncreasingSubsequence().lengthOfLIS1(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(new Q300_LongestIncreasingSubsequence().findProperIndex1(1, new int[] {2,4,6,8,10}, 4));
        System.out.println(new Q300_LongestIncreasingSubsequence().findProperIndex1(3, new int[] {2,4,6,8,10}, 4));
        System.out.println(new Q300_LongestIncreasingSubsequence().findProperIndex1(5, new int[] {2,4,6,8,10}, 4));
        System.out.println(new Q300_LongestIncreasingSubsequence().findProperIndex1(7, new int[] {2,4,6,8,10}, 4));
        System.out.println(new Q300_LongestIncreasingSubsequence().findProperIndex1(9, new int[] {2,4,6,8,10}, 4));
    }
}


