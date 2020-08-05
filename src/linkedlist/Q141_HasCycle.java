package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn create on 2020/07/31
 */
public class Q141_HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, quick = head.next;
        while (quick.next != null && quick.next.next != null && slow != quick) {
            slow = slow.next;
            quick = quick.next.next;
        }

        return slow == quick;

    }
}
