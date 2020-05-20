import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author zerodsLyn create on 2019/06/26
 */
public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        int len = s.length();
        if (len == 0) return true;
        if (len % 2 == 1) return false;

        chars.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                chars.push(c);
            } else {
                if (chars.size() == 0) return false;

                char peek = chars.peek();
                if (c == ')') {
                    if (peek == '(') chars.pop();
                    else return false;
                } else if (c == ']') {
                    if (peek == '[') chars.pop();
                    else return false;
                } else {
                    if (peek == '{') chars.pop();
                    else return false;
                }
            }
        }

        return chars.size() == 0;
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
