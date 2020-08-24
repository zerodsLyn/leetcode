package str;

/**
 * @author zerodsLyn
 * created on 2020/8/24
 */
public class Q459_RepeatedSubStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); ++i) {
            if (s.length() % i == 0) {
                String t = s.substring(0, i);
                boolean flag = true;
                for (int j = i; j + i <= s.length(); j += i) {
                    if (!t.equals(s.substring(j, j + i))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}
