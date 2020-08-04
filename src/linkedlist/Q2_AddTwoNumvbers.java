package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn create on 2020/07/31
 */
public class Q2_AddTwoNumvbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode();
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            head.next = new ListNode(sum);
            head = head.next;
        }
        if (carry == 1) head.next = new ListNode(1);
        return dummy.next;
    }
}
