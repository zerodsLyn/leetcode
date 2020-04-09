/**
 * @author zerods
 * @version 1.0 2020/4/7
 */
public class Q_RotateMatrix {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length <= 1) {
            return;
        }

        int loIndex = 0, hiIndex = matrix.length - 1;;
        while (loIndex < hiIndex) {
            for (int i = loIndex; i <= hiIndex - 1; i++) {
                int left = matrix[loIndex + hiIndex - i][loIndex];
                int up = matrix[loIndex][i];
                int right = matrix[i][hiIndex];
                int down = matrix[hiIndex][loIndex + hiIndex - i];
                matrix[loIndex][i] = left;
                matrix[i][hiIndex] = up;
                matrix[hiIndex][loIndex + hiIndex - i] = right;
                matrix[loIndex + hiIndex - i][loIndex] = down;
            }
            loIndex++;
            hiIndex--;
        }
    }
}
