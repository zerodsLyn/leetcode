/**
 * @author gengchao05 create on 2020/03/22
 */
public class Q945_Minimum_IncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        int length = A.length;
        if (length == 0) {
            return 0;
        }

        int[] B = new int[80002];
        boolean zeroFlag = true;
        for (int i = 0; i < length; i++) {
            int cur = A[i];
            if (cur == 0 && zeroFlag) {
                zeroFlag = false;
                continue;
            } else {
                if (B[cur] == 0 && cur != 0) {
                    B[cur] = cur;
                } else {
                    for (int j = cur + 1; j < 80001; j++) {
                        if (B[j] == 0) {
                            B[j] = j;
                            B[80001] += j - cur;
                            break;
                        }
                    }
                }
            }
        }

        return B[80001];
    }
}
