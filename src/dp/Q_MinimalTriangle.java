package dp;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1030/
 * @author zerodsLyn
 * created on 2020/6/8
 */
public class Q_MinimalTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len;
        if (triangle == null || (len = triangle.size()) == 0) return 0;
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        if (len == 1) return dp[0];

        int min = -1;
        boolean flag = true;
        for (int i = 1; i < len; i++) {
            List<Integer> curRow = triangle.get(i);
            for (int j = i; j >= 0; j--) {
                if (j == 0) {dp[j] = dp[j] + curRow.get(j);}
                else if (j == i) {dp[j] = dp[j - 1] + curRow.get(j);}
                else {dp[j] = Math.min(dp[j - 1], dp[j]) + curRow.get(j);}
                if (i == len - 1) {
                    if (flag) {
                        min = dp[j];
                        flag = false;
                    }
                    else {min = Math.min(min, dp[j]);}
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> row0 = new LinkedList<>();
        row0.add(2);
        List<Integer> row1 = new LinkedList<>();
        row1.add(3);
        row1.add(4);
        List<Integer> row2 = new LinkedList<>();
        row2.add(6);
        row2.add(5);
        row2.add(7);
        List<Integer> row3 = new LinkedList<>();
        row3.add(4);
        row3.add(1);
        row3.add(8);
        row3.add(3);
        triangle.add(row0);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);

        System.out.println(new Q_MinimalTriangle().minimumTotal(triangle));
    }
}
