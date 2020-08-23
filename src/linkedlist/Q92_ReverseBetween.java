package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn
 * created on 2020/8/23
 */
public class Q92_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;

        int curIndex = 1;
        boolean startFind = false;
        ListNode prevEnd = null, cur = head, nextHead = cur.next;
        ListNode start = null;

        while (curIndex < n) {
            if (curIndex == m) {
                startFind = true;
                start = cur;
            }

            if (!startFind) prevEnd = cur;
            cur = nextHead;
            nextHead = nextHead.next;
            curIndex++;
        }

        ListNode newHead = reverse(prevEnd, start, nextHead);
        if (m == 1) return newHead;
        return head;
    }

    public ListNode reverse(ListNode prevEnd, ListNode start, ListNode nextHead) {
        ListNode cur = start;
        ListNode next = cur.next;

        while (next != nextHead) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }

        if (prevEnd != null) prevEnd.next = cur;
        start.next = nextHead;
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(5));
        System.out.println(new Q92_ReverseBetween().reverseBetween(head, 1, 2));
    }
}
