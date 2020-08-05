package linkedlist;

import doublepointer.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @author zerodsLyn create on 2020/03/12
 */
public class Q23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = (start + end) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        return mergeListNode(left, right);
    }

    public ListNode mergeListNode(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (left != null || right != null) {
            if (left == null) {
                tmp.next = right;
                right = right.next;
            } else if (right == null) {
                tmp.next = left;
                left = left.next;
            } else {
                if (left.val < right.val) {
                    tmp.next = left;
                    left = left.next;
                } else {
                    tmp.next = right;
                    right = right.next;
                }
            }

            tmp = tmp.next;
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

//        System.out.println(linkedlist.Q23_MergeKSortedLists.merge(listNode1, listNode2));

        System.out.println(new Q23_MergeKSortedLists().mergeKLists(listNodes));
    }
}
