package math;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * @author zerodsLyn
 * created on 2020/5/16
 */
public class Q66_PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        int[] result = new int[length + 1];
        int carry = 1;
        for (int i = length; i >= 1; i--) {
            int cur = digits[i - 1] + carry;
            if (cur == 10) {
                carry = 1;
                cur = 0;
            } else {
                carry = 0;
            }
            result[i] = cur;
        }
        if (carry == 1) {
            result[0] = 1;
            return result;
        }

        int[] realResult = new int[length];
        for (int i = 0; i < length; i++) {
            realResult[i] = result[i + 1];
        }
        return realResult;
    }
}
