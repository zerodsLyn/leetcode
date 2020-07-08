package tree;

import java.util.*;

/**
 * @author gengchao05 create on 2020/07/07
 */
public class Q_TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q_TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 3)));
        System.out.println(Arrays.toString(new Q_TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5}, 4)));
        System.out.println(Arrays.toString(new Q_TopKFrequentElements().topKFrequent(new int[]{1}, 1)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            if (num2Count.containsKey(num)) {
                num2Count.put(num, num2Count.get(num) + 1);
            } else {
                num2Count.put(num, 1);
            }
        }

        int[] result = new int[k];
        PriorityQueue<NumAndCount> pq = new PriorityQueue<>(k, new Comparator<NumAndCount>(){
            @Override
            public int compare(NumAndCount o1, NumAndCount o2) {
                return Integer.compare(o2.getCount(), o1.getCount());
            }
        });
        for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
            pq.offer(new NumAndCount(entry.getKey(), entry.getValue()));
        }

        int index = 0;
        while (index < k) {
            result[index++] = pq.poll().getNum();
        }

        return result;
    }

    private static class NumAndCount {
        private int num;
        private int count;

        private int getNum() {
            return this.num;
        }

        private int getCount() {
            return this.count;
        }

        public NumAndCount(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
