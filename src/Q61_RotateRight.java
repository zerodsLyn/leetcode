import java.util.HashMap;

/**
 * @author zerodsLyn create on 2020/06/12
 */
public class Q61_RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode tmp = head;
        HashMap<Integer, ListNode> index2Node = new HashMap<>();
        int size = 0;
        while (tmp != null) {
            index2Node.put(size++, tmp);
            tmp = tmp.next;
        }

        k = k % size;
        if (k == 0) return head;

        int newHeadIndex = size - k;
        ListNode listNode = index2Node.get(newHeadIndex);
        ListNode oldTail = index2Node.get(size - 1);
        oldTail.next = head;

        ListNode listNodePrev = index2Node.get(newHeadIndex - 1);
        listNodePrev.next = null;

        return listNode;
    }
}
