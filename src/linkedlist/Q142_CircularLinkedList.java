package linkedlist;

import doublepointer.ListNode;

/**
 * @author gengchao05 create on 2020/05/26
 */
public class Q142_CircularLinkedList {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, quick = head;
        do {
            slow = slow.next;
            quick = quick.next;
            if (quick != null) quick = quick.next;
            else return null;
        } while ( (slow != quick && quick != null));
        if (quick == null) return null;

        slow = head;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println((new Q142_CircularLinkedList()).detectCycle(l1).val);
    }
}
