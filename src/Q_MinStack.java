import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zerodsLyn create on 2020/05/26
 */
public class Q_MinStack {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
}
