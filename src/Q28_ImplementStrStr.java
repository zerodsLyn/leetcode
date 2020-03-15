/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * @author gengchao05 create on 2020/03/15
 */
public class Q28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int sourceLength = haystack.length();
        int targetLength = needle.length();
        if (sourceLength < targetLength) {
            return -1;
        }

        char first = needle.charAt(0);

        int i = 0;
        while (i < haystack.length()) {
            char c = haystack.charAt(i);

            // 只有第一个字符相等的时候才继续处理
            if (c == first) {
                if (sourceLength - i < targetLength) {
                    return -1;
                }

                int startIndex = i;
                i++;
                int j = 1;

                int nextIndex = -1;
                while (j < needle.length()) {
                    char curChar = haystack.charAt(i);
                    if (curChar == c && nextIndex == -1) {
                        nextIndex = i;
                    }
                    if (curChar != needle.charAt(j)) {
                        break;
                    }
                    i++;
                    j++;
                }

                if (j == needle.length()) {
                    return startIndex;
                }

                if (nextIndex != -1) {
                    i = nextIndex;
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q28_ImplementStrStr().strStr("mississippi", "issipi"));
        System.out.println(new Q28_ImplementStrStr().strStr("a", "a"));
        System.out.println(new Q28_ImplementStrStr().strStr("aabbaa", "ab"));
        System.out.println(new Q28_ImplementStrStr().strStr("hello", "ll"));
        System.out.println(new Q28_ImplementStrStr().strStr("hello", "el"));
        System.out.println(new Q28_ImplementStrStr().strStr("hello", "he"));
        System.out.println(new Q28_ImplementStrStr().strStr("hello", "lo"));
        System.out.println(new Q28_ImplementStrStr().strStr("hello", "o"));
    }
}
