package array;

import java.util.PriorityQueue;

/**
 * @author zerodsLyn
 * created on 2020/9/2
 */
public class Q414_ThirdMax {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = nums[0];
        for (int num : nums) {
            if ((queue.size() < 3 || num > queue.peek()) && !queue.contains(num)) {
                queue.offer(num);
            }
            if (queue.size() > 3) {
                queue.poll();
            }
            max = Math.max(max, num);
        }
        return queue.size() < 3 ? max : queue.peek();
    }
}
