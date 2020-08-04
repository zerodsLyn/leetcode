package array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/8/4
 */
public class Q54_SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        spiralOrder(matrix, 0, m - 1, 0, n - 1, result);
        return result;
    }

    public void spiralOrder(int[][] matrix, int m_start, int m_end, int n_start, int n_end, List<Integer> result) {
        if (m_start > m_end || n_start > n_end) return;
        if (m_start == m_end) {
            for (int i = n_start; i <= n_end; i++) result.add(matrix[m_start][i]);
            return;
        }
        if (n_start == n_end) {
            for (int i = m_start; i <= m_end; i++) result.add(matrix[i][n_start]);
            return;
        }
        for (int i = n_start; i <= n_end; i++) result.add(matrix[m_start][i]);
        for (int i = m_start + 1; i <= m_end; i++) result.add(matrix[i][n_end]);
        for (int i = n_end - 1; i >= n_start; i--) result.add(matrix[m_end][i]);
        for (int i = m_end - 1; i > m_start; i--) result.add(matrix[i][n_start]);
        spiralOrder(matrix, m_start + 1, m_end - 1, n_start + 1, n_end - 1, result);
    }
}
