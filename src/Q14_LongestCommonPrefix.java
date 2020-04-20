/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author zerodsLyn create on 2019/04/23
 */

public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int finalIndex = -1;
        int curIndex = 0;
        while (true) {
            char c;
            if (curIndex == strs[0].length()) {
                return finalIndex == -1 ? "" : strs[0].substring(0, finalIndex + 1);
            } else {
                c = strs[0].charAt(curIndex);
            }
            for (int i = 1; i < strs.length; i++) {
                if (curIndex == strs[i].length() || strs[i].charAt(curIndex) != c) {
                    return finalIndex == -1 ? "" : strs[0].substring(0, finalIndex + 1);
                }
            }
            finalIndex = curIndex;
            curIndex++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"fower", "folow", "folight"}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"fow", "fowlow", "fowlight"}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"", ""}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"", "l"}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"l", "l"}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{"aa", "a"}));
        System.out.println(new Q14_LongestCommonPrefix().longestCommonPrefix(new String[]{}));
    }
}
