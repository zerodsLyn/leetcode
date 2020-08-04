package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn
 * created on 2020/8/4
 */
public class Q143_ReOrderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode tail = reverseLinkedList(next);
        while (tail != null) {
            ListNode tailNext = tail.next;
            ListNode headNext = head.next;
            head.next = tail;
            tail.next = headNext;
            head = headNext;
            tail = tailNext;
        }
    }

    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }

        head.next = null;
        return cur;
    }
}
