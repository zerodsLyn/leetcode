package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn create on 2020/07/28
 */
public class Q21_MergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = l1;
        }
        ListNode result = l1;

        ListNode prev = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                ListNode tmp = l2.next;
                l2.next = l1;
                l2 = tmp;
            }
        }

        if (l2 != null) prev.next = l2;
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, null);
        ListNode l2 = new ListNode(1, null);
        System.out.println(new Q21_MergeSortedLinkedList().mergeTwoLists(l1, l2));
    }
}
