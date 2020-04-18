/**
 * @author zerodsLyn create on 2019/06/26
 */

import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                Character peek = stack.isEmpty() ? ' ' : stack.peek();
                if (')' == c) {
                    if (peek == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (']' == c) {
                    if (peek == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if ('}' == c) {
                    if (peek == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
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
