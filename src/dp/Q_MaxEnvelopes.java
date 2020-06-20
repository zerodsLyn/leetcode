package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/6/21
 */
public class Q_MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;

        List<Pair> pairs = new ArrayList<>(envelopes.length);
        for (int[] pair : envelopes) {
            pairs.add(new Pair(pair[0], pair[1]));
        }
        Collections.sort(pairs);

        int max = 1;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) dp[i] = 1;

        for (int i = 0; i < envelopes.length; i++) {
            Pair cur = pairs.get(i);
            for (int j = 0; j < i; j++){
                Pair prev = pairs.get(j);
                if (cur.width > prev.width && cur.height > prev.height) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    static class Pair implements Comparable<Pair> {
        private Integer width;
        private Integer height;

        public Pair(Integer width, Integer height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.width - that.width > 0) return 1;
            if (this.width - that.width < 0) return -1;
            if (this.height - that.height > 0) return 1;
            if (this.height - that.height < 0) return -1;
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q_MaxEnvelopes().maxEnvelopes(new int[][] {
                new int[]{46,89},
                new int[]{50,53},
                new int[]{52,68},
                new int[]{72,45},
                new int[]{77,81},

//                new int[]{5,400},
//                new int[]{5,250},
//                new int[]{6,370},
//                new int[]{6,360},
//                new int[]{7,380}
        }));
    }
}
