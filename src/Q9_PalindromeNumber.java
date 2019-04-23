/**
 * @author gengchao05
 * create on 2019/04/17
 */
/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

    Example 1:
        Input: 121
        Output: true
    Example 2:
        Input: -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:
        Input: 10
        Output: false
        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
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
