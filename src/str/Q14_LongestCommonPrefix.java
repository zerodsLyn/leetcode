package str;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author zerodsLyn create on 2019/04/23
 */

public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 ) return "";
        if (strs.length == 1) return strs[0];

        int index = 0;
        boolean flag = true;
        String curStr = strs[0];
        if (curStr.length() == 0) return "";

        while (flag) {
            char c = curStr.charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == index || strs[i].charAt(index) != c) {
                    flag = false;
                    break;
                }
            }

            if (flag) index++;
            if (index == curStr.length()) break;
        }

        return curStr.substring(0, index);
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
