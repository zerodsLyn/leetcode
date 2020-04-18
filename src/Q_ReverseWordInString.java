import java.util.ArrayList;
import java.util.List;

/**
 * @author zerodsLyn create on 2020/03/29
 */
public class Q_ReverseWordInString {
    public String reverseWords(String origin) {
        if (origin == null) {
            return "";
        }

        String s = origin.trim();
        int length = s.length();
        if (s.length() == 0) {
            return "";
        }

        List<String> strs = new ArrayList<>();

        int start = 0;
        int i = 0;
        while (i < length) {
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            strs.add(s.substring(start, i));

            while (i < length && s.charAt(i) == ' ') {
                i++;
            }

            start = i;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strs.get(strs.size() - 1));

        for(int j = strs.size() - 2; j >= 0; j--) {
            stringBuilder.append(' ').append(strs.get(j));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q_ReverseWordInString().reverseWords("the sky is blue"));
        System.out.println(new Q_ReverseWordInString().reverseWords("  hello world!  "));
        System.out.println(new Q_ReverseWordInString().reverseWords(" "));
        System.out.println(new Q_ReverseWordInString().reverseWords("   a   b "));
    }
}
