/**
 * @author zerodsLyn
 * created on 2020/6/19
 */
public class Q125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        s = s.trim().toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (!isValid(l)) {
                i++;
                continue;
            }
            if (!(isValid(r))) {
                j--;
                continue;
            }
            if (l != r) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }

    private boolean isValid(char c) {
        return ('a' <= c && 'z' >= c) || (c >= '0' && c <= '9');
    }
}
