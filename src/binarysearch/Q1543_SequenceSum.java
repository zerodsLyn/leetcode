package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * @author zerodsLyn create on 2020/03/06
 */
public class Q1543_SequenceSum {
    public int[][] findContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int mid;
        if (target % 2 == 1) {
            mid = target / 2 + 1;
        } else {
            mid = target / 2;
        }

        int lo = 1;
        int hi = 2;
        while (lo < hi && hi <= mid) {
            int sum = (lo + hi) * (hi - lo + 1) / 2;
            if (sum == target) {
                ArrayList<Integer> seq = new ArrayList<>();
                for (int i = lo; i <= hi; i++) {
                    seq.add(i);
                }
                result.add(seq);
                lo++;
            } else if (sum > target) {
                lo++;
            } else {
                hi++;
            }
        }

        int[][] arrayResult = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> integers = result.get(i);
            int[] seq = new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                seq[j] = integers.get(j);
            }
            arrayResult[i] = seq;
        }
        return arrayResult;
    }

    public static void main(String[] args) {
        int[][] continuousSequence = new Q1543_SequenceSum().findContinuousSequence(9);
        for (int[] ints : continuousSequence) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
