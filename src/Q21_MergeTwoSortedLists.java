/**
 * @author zerodsLyn create on 2019/06/13
 */

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Q21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    result.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    result.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }

            result = result.next;
        }

        return tmp.next;
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
