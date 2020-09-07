package hash;

import java.util.*;

/**
 * @author zerodsLyn
 * created on 2020/9/7
 */
public class Q347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            if (num2Count.containsKey(num)) {
                num2Count.put(num, num2Count.get(num) + 1);
            } else {
                num2Count.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entrys = new LinkedList<>(num2Count.entrySet());
        entrys.sort((x, y)-> x.getValue().equals(y.getValue()) ? 0 : (x.getValue() < y.getValue()) ? 1 : -1);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entrys.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q347_TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(new Q347_TopKFrequentElements().topKFrequent(new int[]{1}, 1)));
    }
}
