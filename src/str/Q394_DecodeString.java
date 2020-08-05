package str;

import java.util.Stack;

/**
 * @author zerodsLyn create on 2020/08/05
 */
public class Q394_DecodeString {
    public String decodeString(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return "";

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> parenthesesStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (isParentheses(c)) {
                if (c == '[') {
                    parenthesesStack.push(c);
                } else {
                    parenthesesStack.pop();
                    int count = numStack.pop();
                    String curStr = charStack.pop();
                    StringBuilder tmpStr = new StringBuilder();
                    while (count-- > 0) {
                        tmpStr.append(curStr);
                    }
                    if (charStack.isEmpty()) {
                        charStack.push(tmpStr.toString());
                    } else {
                        charStack.push(charStack.pop() + tmpStr);
                    }

                }
                i++;
            } else if (isNumber(c)) {
                int tmp = i + 1;
                while (isNumber(s.charAt(tmp))) {
                    tmp++;
                }
                int num = Integer.parseInt(s.substring(i, tmp));
                numStack.push(num);
                i = tmp;
            } else {
                int tmp = i + 1;
                while (tmp < len && !(isParentheses(s.charAt(tmp)) || isNumber(s.charAt(tmp)))) {
                    tmp++;
                }
                String str = s.substring(i, tmp);
                if (tmp == len) {
                    if (charStack.isEmpty()) {
                        charStack.push(str);
                    } else {
                        charStack.push(charStack.pop() + str);
                    }
                } else {
                    charStack.push(str);
                }
                i = tmp;
            }
        }

        return charStack.pop();
    }

    private boolean isParentheses(char c) {
        return c == '[' || c == ']';
    }

    private boolean isNumber(char c) {
        return c == '1' || c == '2' || c == '3' ||
                c == '4' || c == '5' || c == '6' ||
                c == '7' || c == '8' || c == '9' || c == '0';
    }

    public static void main(String[] args) {
        System.out.println(new Q394_DecodeString().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Q394_DecodeString().decodeString("leetcode"));
        System.out.println(new Q394_DecodeString().decodeString("100[leetcode]"));
    }
}
