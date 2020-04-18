/**
 * @author zerodsLyn create on 2019/04/22
 */

/*
罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
        同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

    示例 1:
        输入: "III"
        输出: 3

    示例 2:
        输入: "IV"
        输出: 4

    示例 3:
        输入: "IX"
        输出: 9

    示例 4:
        输入: "LVIII"
        输出: 58
        解释: L = 50, V= 5, III = 3.

    示例 5:
        输入: "MCMXCIV"
        输出: 1994
        解释: M = 1000, CM = 900, XC = 90, IV = 4.
*/

public class Q13_Roman2Integer {
    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();

        int curIndex = 0;
        while (curIndex < length) {
            String aChar = s.substring(curIndex, curIndex + 1);
            if (aChar.equals("I")) {
                if (curIndex + 1 < length && (s.charAt(curIndex + 1) == 'V' || s.charAt(curIndex + 1) == 'X')) {
                    aChar = s.substring(curIndex, curIndex + 2);
                    curIndex += 1;
                }
            } else if (aChar.equals("X")) {
                if (curIndex + 1 < length && (s.charAt(curIndex + 1) == 'L' || s.charAt(curIndex + 1) == 'C')) {
                    aChar = s.substring(curIndex, curIndex + 2);
                    curIndex += 1;
                }
            } else if (aChar.equals("C")) {
                if (curIndex + 1 < length && (s.charAt(curIndex + 1) == 'D' || s.charAt(curIndex + 1) == 'M')) {
                    aChar = s.substring(curIndex, curIndex + 2);
                    curIndex += 1;
                }
            }

            result += switchNum(aChar);
            curIndex++;
        }

        return result;
    }

    public int switchNum(String aChar) {
        if (aChar.equals("I")) {
            return 1;
        } else if (aChar.equals("V")) {
            return 5;
        } else if (aChar.equals("X")) {
            return 10;
        } else if (aChar.equals("L")) {
            return 50;
        } else if (aChar.equals("C")) {
            return 100;
        } else if (aChar.equals("D")) {
            return 500;
        } else if (aChar.equals("M")) {
            return 1000;
        } else if (aChar.equals("IV")) {
            return 4;
        } else if (aChar.equals("IX")) {
            return 9;
        } else if (aChar.equals("XL")) {
            return 40;
        } else if (aChar.equals("XC")) {
            return 90;
        } else if (aChar.equals("CD")) {
            return 400;
        } else if (aChar.equals("CM")) {
            return 900;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q13_Roman2Integer().romanToInt("III"));
        System.out.println(new Q13_Roman2Integer().romanToInt("IV"));
        System.out.println(new Q13_Roman2Integer().romanToInt("IX"));
        System.out.println(new Q13_Roman2Integer().romanToInt("LVIII"));
        System.out.println(new Q13_Roman2Integer().romanToInt("MCMXCIV"));
    }
}
