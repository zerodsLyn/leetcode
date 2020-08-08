package dp;

/**
 * do not consider (()) situation
 * @author zerodsLyn
 * created on 2020/5/3
 */
public class Q32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char curC = s.charAt(i);
            char prevC = s.charAt(i - 1);
            boolean match = curC == ')' && prevC == '(';
            if (i >= 2) {
                dp[i] = match ? (dp[i - 2] + 2) : 0;
            } else {
                dp[i] = match ? 2 : 0;
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q32_LongestValidParentheses().longestValidParentheses(")()())"));
        System.out.println(new Q32_LongestValidParentheses().longestValidParentheses("()()())"));
        System.out.println(new Q32_LongestValidParentheses().longestValidParentheses("((()()())))"));
        System.out.println(new Q32_LongestValidParentheses().longestValidParentheses("))(("));
        System.out.println(new Q32_LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
