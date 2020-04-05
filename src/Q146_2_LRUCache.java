import java.util.HashMap;

/**
 * @author zerods
 * @version 1.0 2020/4/5
 */
public class Q146_2_LRUCache {
    private int capacity;
    private int size;
    private HashMap<Integer, Node> key2Node;
    private Node head;
    private Node tail;

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;


        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "->" + (next == null ? "/" : next.toString());
        }
    }

    public Q146_2_LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.key2Node = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!key2Node.containsKey(key)) {
            return -1;
        }
        Node node = key2Node.get(key);
        put2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value, null, null);
        if (isEmpty()) {
            init(node);
            key2Node.put(key, node);
        } else {
            if (key2Node.containsKey(key)) {
                node = key2Node.get(key);
                node.value = value;
                put2Head(node);
            } else {
                if (isFull())  {
                    Node newTail = tail.prev;
                    key2Node.remove(tail.key);
                    if (newTail == null) {
                        tail = null;
                        head = null;
                    } else {
                        newTail.next = null;
                        tail = newTail;
                    }
                    size--;
                }

                put2Head(node);
                size++;
                key2Node.put(key, node);
            }
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private void put2Head(Node node) {
        if (node == head) {
            return;
        }
        if (isEmpty()) {
            init(node);
        } else {
            Node prev = node.prev;
            Node next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }

            if (tail == node) {
                tail = prev;
            }
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }

    private void init(Node node) {
        head = node;
        tail = node;
        size = 1;
    }

    @Override
    public String toString() {
        return head.toString();
    }

    public static void main(String[] args) {
        Q146_2_LRUCache cache = new Q146_2_LRUCache( 2);


        cache.put(1, 1);
        cache.put(2, 2);
        // 1
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        // -1
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        // -1
        System.out.println(cache.get(1));
        // 3
        System.out.println(cache.get(3));
        // 4
        System.out.println(cache.get(4));

    }
}
