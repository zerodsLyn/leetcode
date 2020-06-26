package linkedlist;

import doublepointer.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zerodsLyn
 * created on 2020/6/26
 */
public class Q0201_RemoveDuplicateNode {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> vals = new HashSet<>();
        if (head == null || head.next == null) return head;

        vals.add(head.val);
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            int curVal = cur.val;
            if (vals.contains(curVal)) {
                cur = cur.next;
                prev.next = cur;
            } else {
                vals.add(cur.val);
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
