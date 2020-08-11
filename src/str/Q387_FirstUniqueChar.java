package str;

import java.util.HashMap;

/**
 * @author zerodsLyn
 * created on 2020/8/11
 */
public class Q387_FirstUniqueChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> char2Num = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (char2Num.containsKey(c)) {
                char2Num.put(c, char2Num.get(c) + 1);
            } else {
                char2Num.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (char2Num.get(s.charAt(i)) == 1) return i;
        }

        return -1;
    }
}
