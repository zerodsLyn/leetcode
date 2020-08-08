package str;

/**
 * @author zerodsLyn
 * created on 2020/5/19
 */
public class Q680_ValidPalindrome_II {

    public boolean validPalindrome(String s) {
        if (s.length() < 3) return true;

        int l = 0, r = s.length() - 1;
        boolean flag = true;
        while (l < r) {
            char c_l = s.charAt(l);
            char c_r = s.charAt(r);
            if (c_l == c_r) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }

        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            char c_l = s.charAt(left);
            char c_r = s.charAt(right);
            if (c_l == c_r) {
                left += 1;
                right -= 1;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Q680_ValidPalindrome_II().validPalindrome("aba"));
        System.out.println(new Q680_ValidPalindrome_II().validPalindrome("abca"));
        System.out.println(new Q680_ValidPalindrome_II().validPalindrome("adbca"));
        System.out.println(new Q680_ValidPalindrome_II().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(new Q680_ValidPalindrome_II().validPalindrome("pidbliassaqozokmtgahluruufwbjdtayuhbxwoicviygilgzduudzgligyviciowxbhuyatdjbwfuurulhagtmkozoqassailbdip"));
    }
}
