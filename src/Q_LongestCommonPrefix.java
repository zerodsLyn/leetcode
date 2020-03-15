/**
 * @author gengchao05 create on 2020/03/15
 */
public class Q_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String longestCommonPrefix = strs[0];
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            String curStr = strs[i];
            minLength = Math.min(minLength, curStr.length());
            boolean flagAll = true;

            for (int j = 0; j < minLength; j++) {
                char curChar = curStr.charAt(j);
                if (longestCommonPrefix.charAt(j) != curChar) {
                    if (j == 0) {
                        return "";
                    }
                    longestCommonPrefix = longestCommonPrefix.substring(0, j);
                    flagAll = false;
                    break;
                }
            }
            if (flagAll) {
                longestCommonPrefix = longestCommonPrefix.substring(0, minLength);
            }

            minLength = longestCommonPrefix.length();
        }

        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(new Q_LongestCommonPrefix().longestCommonPrefix(new String[] {"acc","aaa","aaba"}));
        System.out.println(new Q_LongestCommonPrefix().longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(new Q_LongestCommonPrefix().longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
