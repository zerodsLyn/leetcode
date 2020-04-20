/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 * @author zerodsLyn create on 2019/04/22
 */

public class Q12_Integer2Roman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int remainder = num % 1000;
        int divider = num / 1000;
        int param0 = divider * 1000;
        handler0(param0, sb);

        int tmp1 = remainder;
        remainder = tmp1 % 100;
        divider = tmp1 / 100;
        int param1 = divider * 100;
        handler1(param1, sb);

        int tmp2 = remainder;
        remainder = tmp2 % 10;
        divider = tmp2 / 10;
        int param2 = divider * 10;
        handler2(param2, sb);

        int param3 = remainder;
        handler3(param3, sb);

        return sb.toString();
    }

    public void handler0(int param, StringBuilder sb) {
        int num = param / 1000;
        while (num-- > 0) {
            sb.append('M');
        }
    }

    public void handler1(int num, StringBuilder sb) {
        if (num == 900) {
            sb.append("CM");
        } else if (500 < num && num < 900) {
            sb.append('D');
            int remainder = num % 500;
            while (remainder > 0) {
                sb.append('C');
                remainder -= 100;
            }
        } else if (num == 500) {
            sb.append('D');
        } else if (num == 400) {
            sb.append("CD");
        } else {
            while (num > 0) {
                sb.append('C');
                num -= 100;
            }
        }
    }

    public void handler2(int num, StringBuilder sb) {
        if (num == 90) {
            sb.append("XC");
        } else if (50 < num && num < 90) {
            sb.append('L');
            int remainder = num % 50;
            while (remainder > 0) {
                sb.append('X');
                remainder -= 10;
            }
        } else if (num == 50) {
            sb.append('L');
        } else if (num == 40) {
            sb.append("XL");
        } else {
            while (num > 0) {
                sb.append('X');
                num -= 10;
            }
        }
    }

    public void handler3(int num, StringBuilder sb) {
        if (num == 9) {
            sb.append("IX");
        } else if (5 < num && num < 9) {
            sb.append('V');
            int remainder = num % 5;
            while (remainder > 0) {
                sb.append('I');
                remainder -= 1;
            }
        } else if (num == 5) {
            sb.append('V');
        } else if (num == 4) {
            sb.append("IV");
        } else {
            while (num > 0) {
                sb.append('I');
                num -= 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q12_Integer2Roman().intToRoman(3));
        System.out.println(new Q12_Integer2Roman().intToRoman(4));
        System.out.println(new Q12_Integer2Roman().intToRoman(9));
        System.out.println(new Q12_Integer2Roman().intToRoman(58));
        System.out.println(new Q12_Integer2Roman().intToRoman(1994));
    }
}
