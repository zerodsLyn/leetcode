package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn
 * created on 2020/8/4
 */
public class Q83_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (prev.val == cur.val) {
                ListNode next = cur.next;
                prev.next = next;
                cur.next = null;
                cur = next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
