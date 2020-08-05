package lru;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * @author zerodsLyn create on 2020/03/19
 */
public class Q146_LRUCache {

    HashMap<Integer, Node> map;
    Node head, tail;
    int size;
    int capacity;

    public Q146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);
    }

    @Override
    public String toString() {
        return head.toString();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.next != tail) {
                move2Last(node);
            }
            return map.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            move2Last(node);
        } else {
            size++;
            if (size > capacity) {
                Node next = head.next;
                head.next = next.next;
                next.next.prev = head;
                map.remove(next.key);
                size--;
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            move2Last(newNode);
        }
    }

    private void move2Last(Node node) {
        if (node.prev != null) {
            Node next = node.next;
            node.prev.next = next;
            next.prev = node.prev;
        }
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        @Override
        public String toString() {
            if (next == null) {
                return value + "";
            } else {
                return value + "->" + next.toString();
            }
        }
    }

    public static void main(String[] args) {
        Q146_LRUCache cache = new Q146_LRUCache( 2 /* 缓存容量 */ );

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
