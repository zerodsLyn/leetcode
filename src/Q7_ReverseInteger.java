/**
 * @author gengchao05 create on 2019/04/15
 */

/*
Given a 32-bit signed integer, reverse digits of an integer.

        Example 1:
            Input: 123
            Output: 321

        Example 2:
            Input: -123
            Output: -321

        Example 3:
            Input: 120
            Output: 21
    Note:
        Assume we are dealing with an environment which could only store integers
        within the 32-bit signed integer range: [−231,  231 − 1].
        For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/
public class Q7_ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int minus = x >= 0 ? 1 : -1;
        int positiveVal = x * minus;

        String str = String.valueOf(positiveVal);

        String reversedStr = new StringBuffer(str).reverse().toString();
        int index = 0;
        for (int i = 0; i < reversedStr.length(); i++) {
            if (reversedStr.charAt(i) != '0') {
                index = i;
                break;
            }
        }

        String strResult = index != reversedStr.length() ? reversedStr.substring(index) : reversedStr;
        if (Long.valueOf(strResult) > Integer.MAX_VALUE) {
            return 0;
        }

        return Integer.valueOf(strResult) * minus;
    }

    public static void main(String[] args) {
        int input_x = 123;
        System.out.println(new Q7_ReverseInteger().reverse(input_x));
        input_x = -123;
        System.out.println(new Q7_ReverseInteger().reverse(input_x));
        input_x = 120;
        System.out.println(new Q7_ReverseInteger().reverse(input_x));
    }
}
