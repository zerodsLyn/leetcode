/**
 * @author gengchao05 create on 2020/03/26
 */
public class Q999_AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int R_x = 0;
        int R_y = 0;
        boolean find = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char c = board[i][j];
                if (c == 'R') {
                    R_x = i;
                    R_y = j;
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }

        char[] x_a = board[R_x];
        int count = 0;
        for (int i = R_y - 1; i >= 0; i--) {
            char c = x_a[i];
            if (c == 'B') {
                break;
            } else if (c == 'p') {
                count++;
                break;
            }
        }
        for (int i = R_y + 1; i < 8; i++) {
            char c = x_a[i];
            if (c == 'B') {
                break;
            } else if (c == 'p') {
                count++;
                break;
            }
        }


        for (int i = R_x - 1; i >= 0; i--) {
            char c = board[i][R_y];
            if (c == 'B') {
                break;
            } else if (c == 'p') {
                count++;
                break;
            }
        }
        for (int i = R_x + 1; i < 8; i++) {
            char c = board[i][R_y];
            if (c == 'B') {
                break;
            } else if (c == 'p') {
                count++;
                break;
            }
        }

        return count;
    }
}
