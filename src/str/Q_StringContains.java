package str;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 * @author zerodsLyn create on 2020/03/25
 */
public class Q_StringContains {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> char2Index = new HashMap<>(s1.length());
        int l1 = s1.length();
        for (int i = 0; i < l1; i++) {
            Character c = s1.charAt(i);
            if (char2Index.containsKey(c)) {
                char2Index.put(c, char2Index.get(c) + 1);
            } else {
                char2Index.put(c, 1);
            }
        }

        Map<Character, Integer> tempChar2Index = new HashMap<>(char2Index);
        int l2 = s2.length();
        int start = 0;
        while (start < l2 - l1 + 1) {
            int end = start + l1 - 1;
            boolean success = true;
            boolean changed = false;
            for (int i = start; i <= end; i++) {
                Character c = s2.charAt(i);
                if (tempChar2Index.containsKey(c) && tempChar2Index.get(c) > 0) {
                    tempChar2Index.put(c, tempChar2Index.get(c) - 1);
                    changed = true;
                } else {
                    start = start + 1;
                    if (changed) {
                        tempChar2Index = new HashMap<>(char2Index);
                    }
                    success = false;
                    break;
                }
            }

            if (success) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q_StringContains().checkInclusion("ab", "eidbaooo"));
        System.out.println(new Q_StringContains().checkInclusion("ba", "eidboaoo"));
    }
}
