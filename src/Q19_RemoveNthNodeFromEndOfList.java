/**
 * @author gengchao05
 * create on 2019/06/13
 */

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 */
public class Q19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int size = 1;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }

        int idx = size - n;
        if (idx == 0) {
            head = head.next;
            return head;
        }

        int i = 0;
        cur = head;
        ListNode pre = head;
        while (i < idx) {
            i++;
            pre = cur;
            cur = cur.next;
        }

        if (cur == null) {
            pre.next = null;
            return head;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);

        System.out.println(new Q19_RemoveNthNodeFromEndOfList().removeNthFromEnd(l1, 3));
    }
}
