package doublepointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zerodsLyn
 * created on 2020/5/23
 */
public class Q76_MinimumWindowSubstring {
    int[] needCharSet = new int[128];
    int[] curChar2Num = new int[128];

    public String minWindow(String s, String t) {
        int lenT;
        if ((lenT = t.length()) == 0 || s.length() < lenT) return "";

        HashSet<Character> chars = new HashSet<>(lenT);
        for (int i = 0; i < lenT; i++) {
            char c = t.charAt(i);
            needCharSet[c] = needCharSet[c] + 1;
            chars.add(c);
        }

        int minStart = 0, minLength = s.length() + 1;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);

            if (needCharSet[c] > 0) {
                // 包含放入字符集合，再判断是否覆盖
                curChar2Num[c] = curChar2Num[c] + 1;

                // 快速失败
                while (contains(needCharSet, curChar2Num, chars)) {
                    // 如果已经覆盖了，就可以左移，缩容
                    if (right - left + 1 < minLength) {
                        minStart = left;
                        minLength = right - left + 1;
                    }

                    char leftC = s.charAt(left);
                    left++;
                    if (needCharSet[leftC] > 0) {
                        int num = curChar2Num[leftC] - 1;
                        curChar2Num[leftC] = num;
                        if (num <= 0) break;
                    }
                }
            }

            right++;
        }

        if (minLength == s.length() + 1) return "";
        return s.substring(minStart, minStart + minLength);
    }

    private boolean contains(int[] needChars, int[] curChars, HashSet<Character> chars) {
        for (Character character : chars) {
            if (curChars[character] < needChars[character]) {
                 return false;
            }
        }
        return true;
    }

    public String minWindow1(String s, String t) {
        int[] needs = new int[128];
        int[] window = new int[128];
        for (char ch : t.toCharArray()) {
            needs[ch] = needs[ch] + 1;
        }
        int l = 0, r = 0, plength = t.length();

        //候选字符数
        int count = 0;
        int minLength = s.length() + 1;
        String result = "";
        while (r < s.length()) {
            char ch = s.charAt(r);
            window[ch] = window[ch] + 1;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) count++;

            while (count == plength) {
                ch = s.charAt(l);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) count--;

                if ((r - l) + 1 < minLength) {
                    minLength = (r - l) + 1;
                    result = s.substring(l, r + 1);
                }
                window[ch] = window[ch] - 1;
                l++;
            }
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q76_MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }
}
