/**
 * @author gengchao05 create on 2019/06/27
 */

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ),
 * the plus + or minus sign -, non-negative integers and empty spaces .
 *
 */
public class Q224_BasicCalculator {
    public int calculate(String so) {
        String s = so.trim();
        String s1 = s.replaceAll("[^0-9]", "-");

        Stack<Integer> operators = new Stack<Integer>();
        Stack<Character> operands = new Stack<Character>();
        int length = s.length();
        int index = 0;
        while (index < length || !operands.isEmpty()) {
            char c = s.charAt(index);
            if (c == ' ') {
                index++;
                continue;
            } else if (isSign(c) || isParentheses(c)) {
                if (c == ')') {
                    operands.pop();
                } else {
                    operands.push(c);
                    index++;
                    continue;
                }
                index++;
            } else {
                int nextSignIndex = findNextSign(s1, index);
                operators.push(Integer.parseInt(s.substring(index, nextSignIndex)));
                index = nextSignIndex;
            }

            Character operand;
            if ((!operands.isEmpty() && isSign(operand = operands.peek())) && operators.size() > 1) {
                Integer v2 = operators.pop();
                Integer v1 = operators.pop();
                if (operand == '+') {
                    operators.push(v1 + v2);
                } else {
                    operators.push(v1 - v2);
                }
                operands.pop();
            }
        }

        return operators.peek();
    }

    public boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    public boolean isParentheses(char c) {
        return c == '(' || c == ')';
    }

    public int findNextSign(String s, Integer index) {
        int r = s.length();
        int x = s.indexOf('-', index + 1);
        r = (x == -1) ? r : (r < x) ? r : x;

        return r;
    }

    public int findNextSign1(String s, Integer index) {
        int r = s.length();
        s.replaceAll("[^0-9]", "-");
        int x = s.indexOf('(', index + 1);
        r = (x == -1) ? r : (r < x) ? r : x;
        int y = s.indexOf(')', index + 1);
        r = (y == -1) ? r : (r < y) ? r : y;
        int m = s.indexOf('+', index + 1);
        r = (m == -1) ? r : (r < m) ? r : m;
        int n = s.indexOf('-', index + 1);
        r = (n == -1) ? r : (r < n) ? r : n;
        int z = s.indexOf(' ', index + 1);
        r = (z == -1) ? r : (r < z) ? r : z;

        return r;
    }

    public static void main(String[] args) {
        Q224_BasicCalculator q224_basicCalculator = new Q224_BasicCalculator();
        System.out.println(q224_basicCalculator.calculate("((1+(((4+5)+2))-3))+(6+8)"));
        System.out.println(q224_basicCalculator.calculate("1+1"));
        System.out.println(q224_basicCalculator.calculate("2- 1 + 2"));
        System.out.println(q224_basicCalculator.calculate("2147483647"));
        System.out.println(q224_basicCalculator.calculate("  30"));
        System.out.println(q224_basicCalculator.calculate(" 1-11"));
        System.out.println(q224_basicCalculator.calculate("(7)-(0)+(4)"));
        System.out.println(q224_basicCalculator.calculate("2-(5-6)"));

        /*String s1 = "(7)-(0)+(4)".replaceAll("[^0-9]", "-");
        System.out.println(s1);*/
    }
}
