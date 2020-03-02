/**
 * @author gengchao05 create on 2019/04/22
 */
/*

罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

    字符          数值
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
    数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。

    这个特殊的规则只适用于以下六种情况：

        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。


    示例 1:
    输入: 3
    输出: "III"

    示例 2:
    输入: 4
    输出: "IV"

    示例 3:
    输入: 9
    输出: "IX"

    示例 4:
    输入: 58
    输出: "LVIII"
    解释: L = 50, V = 5, III = 3.

    示例 5:
    输入: 1994
    输出: "MCMXCIV"
    解释: M = 1000, CM = 900, XC = 90, IV = 4.
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
