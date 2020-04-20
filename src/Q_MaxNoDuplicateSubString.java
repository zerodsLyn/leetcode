import java.util.HashMap;

/**
 * @author zerodsLyn create on 2020/03/13
 */
public class Q_MaxNoDuplicateSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int maxCount = 1;
        HashMap<Character, Integer> curChars = new HashMap<>();

        int start = 0;
        boolean isOver = false;
        for (int i = 0; i < s.length(); i++) {
            isOver = false;
            Character curChar = s.charAt(i);
            boolean contains = curChars.containsKey(curChar);
            boolean containsNow = contains && curChars.get(curChar) >= start;
            if (!containsNow) {
                curChars.put(curChar, i);
            } else {
                Integer index = curChars.get(curChar);
                if (i - start > maxCount) {
                    maxCount = i - start ;
                }
                curChars.put(curChar, i);
                start = index + 1;
                isOver = true;
            }
        }

        if (!isOver) {
            return Math.max(maxCount, s.length() - start);
        }

        return maxCount;

    }

    public static void main(String[] args) {
        System.out.println(new Q_MaxNoDuplicateSubString().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Q_MaxNoDuplicateSubString().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Q_MaxNoDuplicateSubString().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Q_MaxNoDuplicateSubString().lengthOfLongestSubstring("aab"));
        System.out.println(new Q_MaxNoDuplicateSubString().lengthOfLongestSubstring("cdd"));
        System.out.println(new Q_MaxNoDuplicateSubString().lengthOfLongestSubstring("tmmzuxt"));
    }
}
