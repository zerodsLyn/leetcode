package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn
 * created on 2020/5/16
 */
public class Q25_ReverseLinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode newHead = null;

        int cur = 1;
        ListNode curStart = head, curEnd = head, nextStart = head;
        ListNode prevEnd = null;
        while (curStart != null) {
            while (curEnd != null && cur < k) {
                curEnd = curEnd.next;
                cur++;
            }

            if (curEnd == null) break;
            if (newHead == null) newHead = curEnd;

            nextStart = curEnd.next;
            reverseLinkedList(curStart, curEnd);
            curStart.next = nextStart;
            if (prevEnd != null) prevEnd.next = curEnd;

            prevEnd = curStart;
            cur = 1;
            curStart = nextStart;
            curEnd = curStart;

        }

        return newHead;
    }

    private void reverseLinkedList(ListNode oldHead, ListNode oldEnd) {
        ListNode cur = oldHead;
        ListNode next = cur.next;
        while (cur != oldEnd) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(new Q25_ReverseLinkedList().reverseKGroup(listNode, 2));
    }
}
