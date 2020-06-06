import java.util.Stack;

/**
 * @author zerodsLyn create on 2020/05/28
 */
public class Q394_DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int i = 0;

        char c;
        while (i < s.length()) {
            if ((c = s.charAt(i)) != ']') {
                stack.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while ((c = stack.pop()) != '[') sb.append(c);
                String curStr = sb.reverse().toString();

                StringBuilder countSb = new StringBuilder();
                while (!stack.isEmpty() && (c = stack.peek().charValue()) >= 48 &&  c <= 57) countSb.append(stack.pop());
                String curCount = countSb.reverse().toString();

                int count = Integer.parseInt(curCount);
                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < curStr.length(); k++) {
                        stack.push(curStr.charAt(k));
                    }
                }
            }
            i++;
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        /*System.out.println(new Q_DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new Q_DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new Q_DecodeString().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Q_DecodeString().decodeString("10[abc]"));*/
        System.out.println(new Q394_DecodeString().decodeString("23[a]56[b]89[c]"));
    }
}
