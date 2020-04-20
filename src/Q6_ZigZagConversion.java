/**
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @author zerodsLyn create on 2019/04/16
 */

public class Q6_ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int length = s.length();
        char[][] board = new char[numRows][length];
        int row = 0;
        int col = 0;
        boolean down = true;

        for (int i = 0; i < length; i++) {
            if (down) {
                board[row][col] = s.charAt(i);
                if (row == numRows - 1) {
                    row--;
                    col++;
                    if (row != 0) {
                        down = false;
                    }
                } else {
                    row++;
                }
            } else {
                board[row][col] = s.charAt(i);
                row--;
                col++;
                if (row == 0) {
                    down = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar != '\0') {
                    sb.append(aChar);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q6_ZigZagConversion().convert("ABC", 2));
    }
}
