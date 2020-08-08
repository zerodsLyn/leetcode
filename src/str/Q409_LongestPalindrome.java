package str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zerodsLyn create on 2020/03/19
 */
public class Q409_LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null) {
            return 0;
        }

        int length = s.length();
        if (length < 2) {
            return length;
        }

        int palindromeLength = 0;
        int oddNum = 0;
        Map<Character, Integer> char2Num = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char curChar = s.charAt(i);
            if (char2Num.containsKey(curChar) && char2Num.get(curChar) == 1) {
                char2Num.put(curChar, 0);
                palindromeLength += 2;
                oddNum--;
            } else {
                char2Num.put(curChar, 1);
                oddNum++;
            }
        }

        return oddNum == 0 ? palindromeLength : palindromeLength + 1;
    }
}
