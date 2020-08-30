package str;

/**
 * @author zerodsLyn
 * created on 2020/8/30
 */
public class Q557_ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] strList = s.split(" ");

        for (String str : strList) {
            result.append(reserse(str)).append(" ");
        }

        String re = result.toString();
        return re.substring(0, re.length() - 1);
    }

    private String reserse(String str) {
        StringBuilder result = new StringBuilder();
        int len = str.length();
        for (int i = len - 1; i >= 0; i--) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q557_ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"));
    }
}
