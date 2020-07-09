/**
 * @author zerodsLyn
 * created on 2020/7/8
 */
public class Q_DivingBoards {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[] {};
        if (shorter == longer) {
            int sum = shorter * k;
            return new int[] {sum};
        }

        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            int length = (k - i) * shorter + i * longer;
            result[i] = length;
        }

        return result;
    }
}
