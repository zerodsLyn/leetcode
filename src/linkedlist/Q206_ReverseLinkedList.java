package linkedlist;

import doublepointer.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author zerodsLyn create on 2019/06/13
 */
public class Q206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);

        System.out.println(new Q206_ReverseLinkedList().reverseList(l1));
    }
}
