package dp;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @author zerodsLyn
 * created on 2020/5/3
 */
public class Q32_LongestValidParentheses_V2 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '(') {
                stack.push('(');
                dp[index] = 0;
            } else {
                if (stack.isEmpty()) {
                    dp[index] = -1;
                } else {
                    Character peek = stack.peek();
                    if (peek == '(') {
                        stack.pop();
                        dp[index] = 2;
                    } else {
                        dp[index] = -1;
                    }
                }
            }
            index++;
        }

        int max = 0;
        int curMax = 0;
        int cur2Num = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (dp[i] == -1) {
                max = Math.max(curMax, max);
                curMax = 0;
                cur2Num = 0;
            } else if (dp[i] == 2) {
                curMax += dp[i];
                cur2Num++;
            } else {
                if (cur2Num <= 0) {
                    max = Math.max(curMax, max);
                    curMax = 0;
                    cur2Num = 0;
                }
                if (cur2Num > 0) {
                    cur2Num--;
                }
            }
        }

        return Math.max(max, curMax);
    }

    public static void main(String[] args) {
        System.out.println(new Q32_LongestValidParentheses_V2().longestValidParentheses(")()())"));
        System.out.println(new Q32_LongestValidParentheses_V2().longestValidParentheses("()()())"));
        System.out.println(new Q32_LongestValidParentheses_V2().longestValidParentheses("((()()())))"));
        System.out.println(new Q32_LongestValidParentheses_V2().longestValidParentheses("))(("));
        System.out.println(new Q32_LongestValidParentheses_V2().longestValidParentheses("()(()"));
        System.out.println(new Q32_LongestValidParentheses_V2().longestValidParentheses("()(())"));
        System.out.println(new Q32_LongestValidParentheses_V2().longestValidParentheses(")()(((())))("));
    }
}
