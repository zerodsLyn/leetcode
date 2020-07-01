package dp;

/**
 * @author zerodsLyn create on 2020/07/01
 */
public class Q718_MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length;
        if (aLen == 0 || bLen == 0) return 0;

        int max = 0;
        int[][] dp = new int[aLen][bLen];
        for (int i = 0; i < aLen; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int j = 0; j < bLen; j++) {
            if (A[0] == B[j]) {
                dp[0][j] = 1;
                max = 1;
            }
        }
        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (A[i] == B[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
