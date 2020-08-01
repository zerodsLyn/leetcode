package str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zerodsLyn
 * created on 2020/7/29
 */
public class Q3_LongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int result = 0;
        Map<Character, Integer> num2Index = new HashMap<>();
        while (r < n) {
            char c = s.charAt(r);
            if (num2Index.containsKey(c)) {
                int idx = num2Index.get(c);
                if (idx >= l) l = idx + 1;
            }
            num2Index.put(c, r);
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
