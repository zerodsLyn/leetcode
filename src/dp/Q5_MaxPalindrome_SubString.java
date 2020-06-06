package dp;

/**
 * @author zerodsLyn create on 2020/05/21
 */
public class Q5_MaxPalindrome_SubString {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int max = 0, begin = 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < len; j++) {
            char r = s.charAt(j);
            for (int i = 0; i < j; i++) {
                char l = s.charAt(i);
                if (l == r) {
                    if (j - i < 3 || dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                        if (j - i > max) {
                            max = j - i;
                            begin = i;
                        }
                    }
                }
            }
        }

        return s.substring(begin, begin + max + 1);
    }
}
