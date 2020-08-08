package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerods
 * @version 1.0 2020/4/14
 */
public class Q445_TwoNumsAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverseLinkedList(l1);
        ListNode head2 = reverseLinkedList(l2);
        int sign = 0;
        ListNode result = null;
        ListNode tmp = null;
        while (head1 != null || head2 != null || sign == 1) {
            int num1 = 0;
            if (head1 != null) {
                num1 = head1.val;
            }

            int num2 = 0;
            if (head2 != null) {
                num2 = head2.val;
            }

            int curResult = num1 + num2 + sign;
            int num = curResult % 10;
            sign = curResult / 10;
            if (result == null) {
                result = new ListNode(num);
                tmp = result;
            } else {
                tmp.next = new ListNode(num);
                tmp = tmp.next;
            }

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        return reverseLinkedList(result);
    }

    private ListNode reverseLinkedList(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }

        ListNode cur = listNode;
        ListNode next = cur.next;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        listNode.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        System.out.println((new Q445_TwoNumsAdd()).addTwoNumbers(l1, l2));
    }
}