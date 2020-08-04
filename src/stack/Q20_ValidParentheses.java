package stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author zerodsLyn create on 2019/06/26
 */
public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ']' || c == '}' || c == ')') {
                if (stack.isEmpty()) return false;
                char peek = stack.peek();
                if (c == ']') {
                    if (peek == '[') stack.pop();
                    else return false;
                } else if (c == '}') {
                    if (peek == '{') stack.pop();
                    else return false;
                } else {
                    if (peek == '(') stack.pop();
                    else return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Q20_ValidParentheses().isValid("()"));
        System.out.println(new Q20_ValidParentheses().isValid("()[]{}"));
        System.out.println(new Q20_ValidParentheses().isValid("(]"));
        System.out.println(new Q20_ValidParentheses().isValid("([)]"));
        System.out.println(new Q20_ValidParentheses().isValid("{{}}"));
        System.out.println(new Q20_ValidParentheses().isValid("]"));
    }
}
