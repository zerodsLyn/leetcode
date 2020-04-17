import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gengchao05 create on 2020/04/16
 */
public class Q56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        List<Pair> results = new LinkedList<>();
        List<Pair> pairs = buildPairs(intervals);
        Pair head = pairs.get(0);
        int prevLeft = head.left;
        int prevRight = head.right;

        for (int i = 1; i < pairs.size(); i++) {
            Pair curPair = pairs.get(i);
            int curLeft = curPair.left;
            int curRight = curPair.right;
            if (curLeft > prevRight) {
                results.add(new Pair(prevLeft, prevRight));
                prevLeft = curLeft;
                prevRight = curRight;
            } else {
                prevRight = Math.max(prevRight, curRight);
            }
        }

        results.add(new Pair(prevLeft, prevRight));
        return buildIntervals(results);
    }

    private List<Pair> buildPairs(int[][] intervals) {
        List<Pair> pairs = new LinkedList<>();
        for (int[] leftAndRight : intervals) {
            pairs.add(new Pair(leftAndRight[0], leftAndRight[1]));
        }

        pairs.sort(Comparator.comparingInt(Pair::left));
        return pairs;
    }

    private int[][] buildIntervals(List<Pair> pairs) {
        int[][] results = new int[pairs.size()][2];
        int index = 0;
        for (Pair pair : pairs) {
            results[index++] = (new int[] {pair.left, pair.right});
        }
        return results;
    }

    static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int left() {
            return this.left;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1,4},{4,5}
        };
        /*int[][] ;*/
        System.out.println(Arrays.deepToString(new Q56_MergeIntervals().merge(intervals)));

        intervals = new int[][] {
                {1,3},{2,6},{8,10}, {15,18}
        };
        System.out.println(Arrays.deepToString(new Q56_MergeIntervals().merge(intervals)));
    }
}
