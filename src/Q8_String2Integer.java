/**
 * @author gengchao05 create on 2019/04/17
 */
/*

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

*/

public class Q8_String2Integer {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String trimStr = str.trim();
        int length = trimStr.length();
        if (length == 0) {
            return 0;
        }
        int minus = 1;
        if (trimStr.charAt(0) == '+') {
            minus = 1;
            if (trimStr.length() == 1) {
                return 0;
            }
            trimStr = trimStr.substring(1);
            length--;
        } else if (trimStr.charAt(0) == '-') {
            minus = -1;
            if (trimStr.length() == 1) {
                return 0;
            }
            trimStr = trimStr.substring(1);
            length--;
        }
        int index = 0;
        while (trimStr.charAt(index) == '0') {
            index++;
            if (index == trimStr.length()) {
                break;
            }
        }
        if (index == trimStr.length()) {
            return 0;
        } else {
            trimStr = trimStr.substring(index);
        }

        if (!Character.isDigit(trimStr.charAt(0))) {
            return 0;
        }

        int lastDigitIndex = 0;
        while (lastDigitIndex < trimStr.length()) {
            if (Character.isDigit(trimStr.charAt(lastDigitIndex))) {
                lastDigitIndex++;
            } else {
                break;
            }
        }

        String lastNonDigitCharRemovedStr = trimStr.substring(0, lastDigitIndex);
        int finalLength = lastNonDigitCharRemovedStr.length();
        for (int i = 0; i < finalLength; i++) {
            if (!Character.isDigit(lastNonDigitCharRemovedStr.charAt(i))) {
                return 0;
            }
        }

        String maxLongStr = String.valueOf(Long.MAX_VALUE);
        if (lastNonDigitCharRemovedStr.length() > maxLongStr.length()) {
            return minus == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if (lastNonDigitCharRemovedStr.length() == maxLongStr.length() && lastNonDigitCharRemovedStr.compareTo(maxLongStr) > 0) {
            return minus == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        long val = Long.valueOf(lastNonDigitCharRemovedStr) % Long.MAX_VALUE;
        if (minus == 1 && val > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (minus == -1 && val >= (Integer.MAX_VALUE + 1L)) {
            return Integer.MIN_VALUE;
        }

        return Integer.valueOf(lastNonDigitCharRemovedStr) * minus;
    }

    public static void main(String[] args) {
        System.out.println(new Q8_String2Integer().myAtoi("42"));
        System.out.println(new Q8_String2Integer().myAtoi("   -42"));
        System.out.println(new Q8_String2Integer().myAtoi("4193 with words"));
        System.out.println(new Q8_String2Integer().myAtoi("words and 987"));
        System.out.println(new Q8_String2Integer().myAtoi("-91283472332"));
        System.out.println(new Q8_String2Integer().myAtoi("9l9ldasdasdhj"));
        System.out.println(new Q8_String2Integer().myAtoi("-2147483648"));
        System.out.println(new Q8_String2Integer().myAtoi("20000000000000000000"));
        System.out.println(new Q8_String2Integer().myAtoi("3.14159"));
        System.out.println(new Q8_String2Integer().myAtoi("-"));
        System.out.println(new Q8_String2Integer().myAtoi("+1"));
        System.out.println(new Q8_String2Integer().myAtoi("-000000000000000000000000000000000000000000000000001"));
        System.out.println(new Q8_String2Integer().myAtoi("+-2"));
        System.out.println(new Q8_String2Integer().myAtoi("20000000000000000000"));
    }

}
