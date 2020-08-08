package str;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * @author zerodsLyn create on 2019/04/17
 */

public class Q10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean isFirstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (isFirstMatch && isMatch(s.substring(1), p));
        } else {
            return isFirstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q10_RegularExpressionMatching().isMatch("aa", "a"));
        System.out.println(new Q10_RegularExpressionMatching().isMatch("aa", "*"));
        System.out.println(new Q10_RegularExpressionMatching().isMatch("ab", ".*"));
        System.out.println(new Q10_RegularExpressionMatching().isMatch("aab", "c*a*b"));
    }
}
