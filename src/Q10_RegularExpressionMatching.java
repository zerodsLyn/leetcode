/**
 * @author gengchao05
 * create on 2019/04/17
 */
/*

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
        The matching should cover the entire input string (not partial).

        Note:

        s could be empty and contains only lowercase letters a-z.
        p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
    Input:
    s = "aa"
    p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".
Example 2:
    Input:
    s = "aa"
    p = "a*"
    Output: true
    Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:
    Input:
    s = "ab"
    p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:
    Input:
    s = "aab"
    p = "c*a*b"
    Output: true
    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:
    Input:
    s = "mississippi"
    p = "mis*is*p*."
    Output: false
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
