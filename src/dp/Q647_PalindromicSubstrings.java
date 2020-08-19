package dp;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * @author zerodsLyn
 * created on 2020/8/19
 */
public class Q647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = n;

        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    if (i + 2 >= j || dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Q647_PalindromicSubstrings().countSubstrings("aaaaa"));
    }
}
