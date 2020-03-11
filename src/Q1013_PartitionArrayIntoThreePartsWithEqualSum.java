/**
 * @author gengchao05 create on 2020/03/11
 */
public class Q1013_PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int length = A.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += A[i];
        }

        if (sum % 3 != 0) {
            return false;
        }

        int result = sum / 3;
        int count = 0;
        int curSum = 0;
        for (int i = 0; i < length; i++) {
            curSum += A[i];
            if (curSum == result) {
                count++;
                curSum = 0;
                if (count == 3) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q1013_PartitionArrayIntoThreePartsWithEqualSum().canThreePartsEqualSum(new int[] {0, 0, 0, 0}));
    }
}
