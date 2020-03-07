import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author gengchao05 create on 2020/03/07
 */
public class Q1548_MaxQueue {

    private LinkedList<Integer> linkedList = new LinkedList<>();

    private int maxValue = -1;

    public Q1548_MaxQueue() {

    }

    public int max_value() {
        return maxValue;
    }

    public void push_back(int value) {
        linkedList.addLast(value);
        if (value > maxValue) {
            maxValue = value;
        }
    }

    public int pop_front() {
        if (linkedList.size() == 0) {
            return -1;
        }

        int front =  linkedList.removeFirst();
        if (front == maxValue) {
            Iterator<Integer> iterator = linkedList.iterator();
            int max = -1;
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next > max) {
                    max = next;
                }
            }
            maxValue = max;
        }

        return front;
    }

    public static void main(String[] args) {
        Q1548_MaxQueue obj = new Q1548_MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(1);
        obj.push_back(2);

        System.out.println(obj.maxValue);
        int param_3 = obj.pop_front();
        System.out.println(param_3);

        System.out.println(obj.maxValue);

        obj.push_back(1);
        int param_4 = obj.pop_front();
        System.out.println(param_4);
        System.out.println(obj.maxValue);
    }
}
