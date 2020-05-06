package dp;

/**
 * @author zerodsLyn
 * created on 2020/5/6
 */
public class Q983_MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        int minDay = days[0], maxDay = days[length - 1];

        int[] dp = new int[maxDay + 31];
        int dpIndex = maxDay;
        for (int i = length - 1; dpIndex >= minDay; dpIndex--) {
            if (dpIndex == days[i]) {
                dp[dpIndex] = Math.min(Math.min(costs[1] + dp[dpIndex + 7], costs[0] + dp[dpIndex + 1]), costs[2] + dp[dpIndex + 30]);
                i--;
            } else {
                dp[dpIndex] = dp[dpIndex + 1];
            }

        }

        return dp[minDay];
    }
}
