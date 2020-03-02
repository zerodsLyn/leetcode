/**
 * @author gengchao05 create on 2019/04/11
 */
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

        Example 1:

        Input: "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
        Example 2:

        Input: "cbbd"
        Output: "bb"
*/

public class Q5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        if (isPalindrome(s)) {
            return s;
        }

        String result = s.substring(0, 1);
        for (int i = 0; i < n; i++) {
            String single = getLongestString(s, i, i);
            String two = getLongestString(s, i, i + 1);
            String curLongerResult = single.length() > two.length() ? single : two;
            result = curLongerResult.length() > result.length() ? curLongerResult : result;
        }

        return result;
    }

    public String getLongestString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public boolean isPalindrome(String s) {
        int size = s.length();
        if (size <= 1) {
            return true;
        }

        int left = 0, right = size - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q5_LongestPalindromicSubstring().longestPalindrome("abba"));
    }
}
