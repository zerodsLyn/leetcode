import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * @author gengchao05 create on 2020/03/09
 */
public class Q120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows;
        if (triangle == null || (rows = triangle.size()) == 0) {
            return 0;
        }

        List<Integer> lastRow = triangle.get(rows - 1);
        int[] minMum = new int[rows];
        for (int i = 0; i < rows; i++) {
            minMum[i] = lastRow.get(i);
        }

        int currentRow = rows - 1;
        while (currentRow >= 1) {
            List<Integer> curVals = triangle.get(currentRow - 1);
            for (int k = 0; k < currentRow; k++) {
                int curVal = curVals.get(k);
                int a = minMum[k];
                int b = minMum[k + 1];

                minMum[k] = Math.min(a, b) + curVal;
            }
            currentRow--;
        }

        return minMum[0];
    }

    public static void main(String[] args) {
        List<Integer> row0 = new ArrayList<>();;
        row0.add(2);
        List<Integer> row1 = new ArrayList<>();;
        row1.add(3);
        row1.add(4);
        List<Integer> row2 = new ArrayList<>();;
        row2.add(6);
        row2.add(5);
        row2.add(7);
        List<Integer> row3 = new ArrayList<>();;
        row3.add(4);
        row3.add(1);
        row3.add(8);
        row3.add(3);

        List<List<Integer>> rows = new ArrayList<>();
        rows.add(row0);
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        System.out.println(new Q120_Triangle().minimumTotal(rows));
    }
}
