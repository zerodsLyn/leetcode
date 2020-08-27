package str;

/**
 * @author zerodsLyn
 * created on 2020/8/27
 */
public class Q58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null)  return 0;
        s = s.trim();

        int len = s.length();
        if (len == 0) return 0;
        char c;
        int i = len - 1;
        int result = 0;
        while (i >= 0 && (c = s.charAt(i)) != ' ') {
            result++;
            i--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q58_LengthOfLastWord().lengthOfLastWord("a"));
    }
}
