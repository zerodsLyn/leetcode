package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * @author zerodsLyn
 * created on 2020/8/13
 */
public class Q118_Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> singleRow = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) singleRow.add(1);
                else {
                    List<Integer> lastRow = result.get(i - 2);
                    singleRow.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            result.add(singleRow);
        }

        return result;
    }
}
