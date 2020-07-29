package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn create on 2020/07/29
 */
public class Q25_ReverseKGroupList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        System.out.println(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode firstHead = null, prevEnd = null;
        ListNode curHead = head, curEnd = head, nextHead = null;
        int i = 0;
        while (i < k || curEnd != null) {
            if (i < k) {
                curEnd = curEnd.next;
                i++;
            } else {
                if (firstHead == null) firstHead = curEnd;
                nextHead = curEnd.next;

                reverseLinkedList(curHead, curEnd);

                if (prevEnd != null) prevEnd.next = curEnd;
                prevEnd = curHead;

                curHead = nextHead;
                curEnd = nextHead;
            }
        }
        return firstHead;
    }

    private void reverseLinkedList(ListNode head, ListNode end) {
        if (head == null) return;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != end) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
        head.next = null;
    }
}
