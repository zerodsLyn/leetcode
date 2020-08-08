package array;

import java.util.Arrays;

/**
 * @author zerodsLyn create on 2020/07/02
 */
public class Q378KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i * n + j] = matrix[i][j];
            }
        }

        Arrays.sort(nums);
        return nums[k - 1];
    }
}
