package offer;

/**
 * @author zerodsLyn create on 2020/03/06
 */
public class Q_interview_10_0_1 {
    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) {
            return;
        }

        int i = m - 1;
        for (; i >= 0; i--) {
            if (A[i] != 0) {
                break;
            }
        }

        if (i < 0) {
            int index = 0;
            if (n >= 0) {
                System.arraycopy(B, 0, A, 0, n);
            }
            return;
        }


        int k = i;
        for (int l = 0; l < n; l++) {
            int cur = B[l];
            int indexA = k;
            while (indexA >= 0) {
                if (A[indexA] > cur) {
                    A[indexA + 1] = A[indexA];
                    indexA--;
                } else {
                    break;
                }
            }
            A[indexA + 1] = cur;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,5,6,0,0,0};
        int[] B = new int[]{2,5,6};
        new Q_interview_10_0_1().merge(A, 6, B, 3);
        for (int i : A) {
            System.out.print(i + " ");
        }

        int[][] arrayResult = new int[5][];

    }
}
