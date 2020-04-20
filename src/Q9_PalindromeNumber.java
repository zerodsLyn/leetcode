/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * @author zerodsLyn create on 2019/04/17
 */

public class Q9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        int tmp = x;
        int N = 20;
        int[] result = new int[N];
        if (tmp < 0) {
            return false;
        } else if (tmp == 0 || tmp < 10) {
            return true;
        } else {
            int index = 0;
            while (tmp != 0) {
                int i = tmp % 10;
                tmp = tmp / 10;
                result[index++] = i;
            }
            int reversedInt = result[0];
            for (int i = 1; i < index; i++) {
                reversedInt = reversedInt * 10 + result[i];
            }
            return reversedInt == x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q9_PalindromeNumber().isPalindrome(121121));
        System.out.println(new Q9_PalindromeNumber().isPalindrome(-121));
        System.out.println(new Q9_PalindromeNumber().isPalindrome(10));
    }
}
