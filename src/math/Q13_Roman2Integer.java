package math;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * @author zerodsLyn create on 2019/04/22
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
