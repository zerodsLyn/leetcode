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
        ListNode start = null, end;

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

        end = cur;
        reverse(start, end, prevEnd, nextHead);
        return head;
    }

    public ListNode reverse(ListNode head, ListNode end, ListNode prevEnd, ListNode nextHead) {
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != nextHead) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }

        if (prevEnd != null) prevEnd.next = cur;
        head.next = nextHead;
        return cur;
    }
}
