package str;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn create on 2020/04/25
 */
public class Q_StringMultiply {
    public String multiply(String num1, String num2) {
        int length1 = num1.length(), length2 = num2.length();
        boolean num1Longer = length1 > length2 ;
        String longNum = num1Longer ? num1 : num2;
        String shortNum = num1Longer ? num2 : num1;
        int shortLength = shortNum.length();
        int longLength = longNum.length();

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        List<String> nums = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = shortLength - 1; i >= 0; i--) {
            for (int r = 0; r < shortLength - 1 - i; r++) {
                stringBuilder.append('0');
            }

            Integer shortInt = Integer.valueOf(shortNum.substring(i, i+1));
            int flag = 0;
            int j = longLength - 1;
            while (j >= 0) {
                Integer longInt = Integer.valueOf(longNum.substring(j, j+1));
                int multi = shortInt * longInt + flag;
                int mod = multi % 10;
                flag = multi / 10;
                stringBuilder.append(mod);
                j--;
            }

            if (flag > 0) {
                stringBuilder.append(flag);
            }

            nums.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }

        StringBuilder result = new StringBuilder();
        int flag = 0;
        String str = nums.get(nums.size() - 1);
        for (int i = 0; i < str.length(); i++) {
            int val = flag;
            for (String num : nums) {
                if (num.length() > i) {
                    val += Integer.parseInt(num.substring(i, i + 1));
                }
            }

            int divider = val / 10;
            int mod = val % 10;
            flag = divider;
            result.append(mod);
        }
        if (flag > 0) {
            result.append(flag);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q_StringMultiply().multiply("123", "456"));
        System.out.println(new Q_StringMultiply().multiply("2", "3"));
        System.out.println(new Q_StringMultiply().multiply("100", "300"));
    }
}
