package stack;

import java.util.Stack;

/**
 * @author zerodsLyn create on 2020/08/05
 */
public class Q32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len, longest = 0;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            } else {
                stack.push(i);
            }
        }

        return longest;
    }
}
