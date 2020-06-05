import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zerodsLyn create on 2020/05/25
 */
public class Q_AllOne {
    Map<String, Node> map;
    PriorityQueue<Node> maxPriorityQueue;
    PriorityQueue<Node> minPriorityQueue;

    /** Initialize your data structure here. */
    public Q_AllOne() {
        map = new HashMap<>();
        maxPriorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val - o1.val;
            }
        });
        minPriorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node node;
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            int newVal = oldNode.val + 1;
            maxPriorityQueue.remove(oldNode);
            minPriorityQueue.remove(oldNode);
            map.remove(key);

            node = new Node(key, newVal);
        } else {
            node = new Node(key, 1);
        }

        map.put(key, node);
        maxPriorityQueue.add(node);
        minPriorityQueue.add(node);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            int newVal = oldNode.val - 1;
            maxPriorityQueue.remove(oldNode);
            minPriorityQueue.remove(oldNode);
            map.remove(key);

            if (newVal > 0) {
                Node node = new Node(key, newVal);
                map.put(key, node);
                maxPriorityQueue.add(node);
                minPriorityQueue.add(node);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (maxPriorityQueue.isEmpty()) return "";
        return maxPriorityQueue.peek().key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (minPriorityQueue.isEmpty()) return "";
        return minPriorityQueue.peek().key;
    }

    private static class Node {
        String key;
        int val;

        public Node(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Q_AllOne obj = new Q_AllOne();
        obj.inc("a");
        obj.inc("b");
        obj.inc("b");
        obj.inc("c");
        obj.inc("c");
        obj.inc("c");
        obj.dec("b");
        obj.dec("b");
        System.out.println(obj.getMinKey());
        obj.dec("a");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());

    }
}
