/**
 * @author gengchao05 create on 2019/04/16
 */
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
        (you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);
Example 1:

        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"
Example 2:

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
Explanation:
        P     I    N
        A   L S  I G
        Y A   H R
        P     I
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
