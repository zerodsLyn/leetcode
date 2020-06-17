package dp;

/**
 * @author zerodsLyn create on 2020/06/17
 */
public class Q1014_BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int len;
        if (A == null || (len = A.length) == 0) return 0;

        int cur = A[0];
        int max = 0;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, cur + A[i] - i);
            cur = Math.max(cur, A[i] + i);
        }

        return max;
    }
}
