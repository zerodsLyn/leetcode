/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * @author zerodsLyn
 * created on 2020/4/21
 */
public class Q1248_CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int leftIndex = 0, rightIndex = 0, oddCnt = 0, result = 0;

        while (rightIndex < nums.length) {
            if ((nums[rightIndex++] & 1) == 1) {
                oddCnt++;
            }

            if (oddCnt == k) {
                int rightTmp = rightIndex;
                while (rightIndex < nums.length && (nums[rightIndex] & 1) == 0) {
                    rightIndex++;
                }
                int rightEvenCnt = rightIndex - rightTmp;

                int leftEvenCnt = 0;
                while ((nums[leftIndex] & 1) == 0) {
                    leftIndex++;
                    leftEvenCnt++;
                }
                leftIndex++;
                oddCnt--;

                result += (leftEvenCnt + 1) * (rightEvenCnt + 1);
            }
        }

        return result;
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        int res = 0, sum = 0;
        for (int num: nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }
}
