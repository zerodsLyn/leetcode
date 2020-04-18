/**
 * @author zerodsLyn create on 2019/06/13
 */

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Q21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode mergedHead = new ListNode(9999);
        ListNode pre = mergedHead;

        while (head1 != null && head2 != null) {
            ListNode tmp;
            if (head1.val < head2.val) {
                tmp = head1;
                head1 = head1.next;
                pre.next = tmp;
                pre = pre.next;
                tmp.next = null;
            } else {
                tmp = head2;
                head2 = head2.next;
                pre.next = tmp;
                pre = pre.next;
                tmp.next = null;
            }
        }

        if (head1 != null) {
            pre.next = head1;
        } else {
            pre.next = head2;
        }

        return mergedHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(10);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(new Q21_MergeTwoSortedLists().mergeTwoLists(l1, l2));
    }
}
