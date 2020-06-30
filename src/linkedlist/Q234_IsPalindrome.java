package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn create on 2020/06/30
 */
public class Q234_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead;
        if (fast.next == null) {
            // 偶数个
            newHead = slow.next;
            slow.next = null;
        } else {
            // 奇数个
            newHead = slow.next.next;
            slow.next.next = null;
            slow.next = null;
        }
        ListNode node = reverse(newHead);
        while (head != null && node != null) {
            if (head .val != node.val) {
                return false;
            }

            head = head.next;
            node = node.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        head.next = null;
        return cur;
    }
}
