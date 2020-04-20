import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author zerodsLyn create on 2019/04/09
 */


public class Q3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        Map<Character, Integer> char2Index = new HashMap<Character, Integer>();

        int leftIndex = 0;
        int maxLength = 0;
        int curLength = 0;

        for (int i = leftIndex; i < length; i++) {
            char curChar = s.charAt(i);
            Integer index = char2Index.get(curChar);

            if (index != null && index >= leftIndex) {
                char2Index.put(s.charAt(i), i);

                curLength = (i - 1) - leftIndex + 1;
                maxLength = curLength > maxLength ? curLength : maxLength;
                leftIndex = index + 1;
                curLength = i - leftIndex + 1;
            } else {
                char2Index.put(s.charAt(i), i);
                curLength++;
            }
        }

        return maxLength > curLength ? maxLength : curLength;
    }

    public static void main(String[] args) {
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcae"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aabcceda"));
    }
}
