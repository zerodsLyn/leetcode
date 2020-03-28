import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gengchao05 create on 2020/03/28
 */
public class Q82_ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());

        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(words[0]).append("#");
        for (int i = 1; i < words.length; i++) {
            String curWord = words[i];
            if (stringbuilder.indexOf(curWord + "#") == -1) {
                stringbuilder.append(curWord).append("#");
            }
        }

        return stringbuilder.length();
    }
}
