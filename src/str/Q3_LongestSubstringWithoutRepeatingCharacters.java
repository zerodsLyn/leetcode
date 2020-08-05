package str;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author zerodsLyn create on 2019/04/09
 */


public class Q3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length < 2) return length;

        Map<Character, Integer> char2Index = new HashMap<>(length);
        int start = 0, end = 0, longestLength = 0;
        while (end < length) {
            Character c = s.charAt(end);
            if (char2Index.containsKey(c) && start < end) {
                longestLength = Math.max(longestLength, end - start);
                start = Math.max(char2Index.get(c) + 1, start);
            }
            char2Index.put(c, end++);
        }

        return Math.max(longestLength, length - start);
    }

    public static void main(String[] args) {
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcae"));
        System.out.println(new Q3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aabcceda"));
    }
}
