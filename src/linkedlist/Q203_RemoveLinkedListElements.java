package linkedlist;

import doublepointer.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author zerodsLyn
 * created on 2020/9/1
 */
public class Q203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode prev = null, cur = head, next = cur.next;
        while (cur != null) {
            if (cur.val == val) {
                cur.next = null;
                cur = next;
                if (prev != null) {
                    prev.next = next;
                } else {
                    head = cur;
                }
            } else {
                prev = cur;
                cur = next;
            }
            if (cur != null) next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        System.out.println(new Q203_RemoveLinkedListElements().removeElements(l1, 6));
    }
}
