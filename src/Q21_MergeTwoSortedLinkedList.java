/**
 * @author zerodsLyn create on 2020/06/13
 */
public class Q21_MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode tmp;
        if (l1.val > l2.val) {
            tmp = l1; l1 = l2; l2 = tmp;
        }

        ListNode tmpL1 = l1;
        while (l1.next != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            if (next1.val <= l2.val) {
                l1 = next1;
            } else {
                l1.next = l2;
                l2.next = next1;
                l1 = l2;
                l2 = next2;
            }
        }
        if (l2 == null) return tmpL1;
        l1.next = l2;
        return tmpL1;
    }
}
