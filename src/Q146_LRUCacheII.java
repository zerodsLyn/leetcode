import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * @author zerodsLyn create on 2020/03/19
 */
public class Q146_LRUCacheII {

    int size, capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public Q146_LRUCacheII(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = head;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        int val = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            val = node.val;
            addToTail(node);
        }
        return val;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
        } else {
            if (size == capacity) {
                removeHeadNext();
            }
            size++;
            node = new Node(key, value);
            map.put(key, node);

        }

        addToTail(node);
    }

    private void removeHeadNext() {
        if (size == 0) return;

        Node toRemove = head.next;
        head = head.next;
        head.prev.next = null;
        head.prev = null;

        map.remove(toRemove.key);
        size--;
    }

    public void addToTail(Node node) {
        if (node == tail) return;

        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
        node.prev = tail;
        tail.next = node;

        tail = tail.next;
    }

    private static class Node {
        Integer key, val;
        Node prev, next;

        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Q146_LRUCacheII cache = new Q146_LRUCacheII(2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
