package str;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 * @author zerodsLyn
 * created on 2020/7/27
 */
public class Q392_IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int s_len = s.length(), t_len = t.length();
        while (i < s_len && j < t_len) {
            char s_c = s.charAt(i);
            char t_c = t.charAt(j);
            if (s_c == t_c) i++;
            j++;
        }
        return i == s_len;
    }
}
