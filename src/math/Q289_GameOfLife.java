package math;

import java.util.Arrays;

/**
 * @author zerods
 * @version 1.0 2020/4/2
 */
public class Q289_GameOfLife {
    public void gameOfLife(int[][] board) {
        int result = 0;

        int[][] resultBoard = new int[board.length][board[0].length];
        for (int rowNum = 0; rowNum < board.length; rowNum++) {
            int[] aRow = board[rowNum];
            for (int columnNum = 0; columnNum < aRow.length; columnNum++) {
                int num = board[rowNum][columnNum];
                int a00 = 0;
                int a01 = 0;
                int a02 = 0;
                int a10 = 0;
                int a12 = 0;
                int a20 = 0;
                int a21 = 0;
                int a22 = 0;

                if (rowNum > 0) {
                    a01 = board[rowNum - 1][columnNum];
                    if (columnNum > 0) {
                        a00 = board[rowNum - 1][columnNum - 1];
                    }
                    if (columnNum < aRow.length - 1) {
                        a02 = board[rowNum - 1][columnNum + 1];
                    }
                }
                if (rowNum < board.length - 1) {
                    a21 = board[rowNum + 1][columnNum];
                    if (columnNum > 0) {
                        a20 = board[rowNum + 1][columnNum - 1];
                    }
                    if (columnNum < aRow.length - 1) {
                        a22 = board[rowNum + 1][columnNum + 1];
                    }
                }
                if (columnNum > 0) {
                    a10 = board[rowNum][columnNum - 1];
                }
                if (columnNum < aRow.length - 1) {
                    a12 = board[rowNum][columnNum + 1];
                }

                result = a00 + a01 + a02 + a10 + a12 + a20 + a21 + a22;
                if (num == 0) {
                    if (result == 3) {
                        resultBoard[rowNum][columnNum] = 1;
                    }
                } else {
                    if (result < 2 || result > 3) {
                        resultBoard[rowNum][columnNum] = 0;
                    } else {
                        resultBoard[rowNum][columnNum] = 1;
                    }
                }
            }
        }

        for (int rowNum = 0; rowNum < board.length; rowNum++) {
            int[] aRow = board[rowNum];
            System.arraycopy(resultBoard[rowNum], 0, board[rowNum], 0, aRow.length);
        }
    }

    /**
     * [
     *   [0,1,0],
     *   [0,0,1],
     *   [1,1,1],
     *   [0,0,0]
     * ]
     * @param args
     */
    public static void main(String[] args) {
        int[][] a = new int[][] {
                new int[] {0,1,0},
                new int[] {0,0,1},
                new int[] {1,1,1},
                new int[] {0,0,0},
        };

        new Q289_GameOfLife().gameOfLife(a);

        System.out.println(Arrays.deepToString(a));
    }
}
