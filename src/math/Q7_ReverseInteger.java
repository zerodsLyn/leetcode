package math;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author zerodsLyn create on 2019/04/15
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
