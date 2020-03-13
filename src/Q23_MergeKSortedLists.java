/**
 * @author gengchao05 create on 2020/03/12
 */
public class Q23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode mergedLeft = merge(lists, left, mid);
        ListNode mergedRight = merge(lists, mid + 1, right);
        if (mergedLeft == null) {
            return mergedRight;
        }
        if (mergedRight == null) {
            return mergedLeft;
        }
        return merge(mergedLeft, mergedRight);
    }

    public ListNode merge(ListNode mergedLeft, ListNode mergedRight) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (mergedLeft != null && mergedRight != null) {
            int leftVal = mergedLeft.val;
            int rightVal = mergedRight.val;

            if (head.next == null) {
                if (leftVal < rightVal) {
                    ListNode tmp = mergedLeft.next;
                    head.next = mergedLeft;
                    mergedLeft.next = null;
                    mergedLeft = tmp;
                    cur = cur.next;
                } else {
                    ListNode tmp = mergedRight.next;
                    head.next = mergedRight;
                    mergedRight.next = null;
                    mergedRight = tmp;
                    cur = cur.next;
                }
            } else {
                if (leftVal < rightVal) {
                    ListNode tmp = mergedLeft.next;
                    cur.next = mergedLeft;
                    mergedLeft.next = null;
                    mergedLeft = tmp;
                    cur = cur.next;
                } else {
                    ListNode tmp = mergedRight.next;
                    cur.next = mergedRight;
                    mergedRight.next = null;
                    mergedRight = tmp;
                    cur = cur.next;
                }
            }
        }

        while (mergedLeft != null ) {
            ListNode tmp = mergedLeft.next;
            cur.next = mergedLeft;
            mergedLeft.next = null;
            mergedLeft = tmp;
            cur = cur.next;
        }
        while (mergedRight != null) {
            ListNode tmp = mergedRight.next;
            cur.next = mergedRight;
            mergedRight.next = null;
            mergedRight = tmp;
            cur = cur.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = null;

        ListNode listNode2 = new ListNode(-1);
        listNode2.next = new ListNode(5);
        listNode2.next.next = new ListNode(11);

        ListNode listNode3 = null;

        ListNode listNode4 = new ListNode(6);
        listNode4.next = new ListNode(10);

        ListNode[] listNodes = new ListNode[] {listNode1, listNode2, listNode3, listNode4};

//        System.out.println(Q23_MergeKSortedLists.merge(listNode1, listNode2));

        System.out.println(new Q23_MergeKSortedLists().mergeKLists(listNodes));
    }
}
