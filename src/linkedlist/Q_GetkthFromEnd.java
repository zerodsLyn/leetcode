package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn create on 2020/07/24
 */
public class Q_GetkthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int slowN = 1;

        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            slowN++;
        }
        int length;
        if (quick.next == null) length = slowN * 2 - 1;
        else length = slowN * 2;

        ListNode tmp;
        int index = length - k;
        int i;
        if (index < slowN) {
            tmp = head;
            i = 0;
        } else {
            tmp = slow;
            i = slowN - 1;
        }
        while (i < index) {
            tmp = tmp.next;
            i++;
        }

        return tmp;
    }
}
