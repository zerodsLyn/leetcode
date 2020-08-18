package tree;

import doublepointer.ListNode;

/**
 * @author zerodsLyn
 * created on 2020/8/18
 */
public class Q109_SortedLinkedList2BinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        if (head.next.next == null) return new TreeNode(head.val, null, new TreeNode(head.next.val));

        ListNode mid = root(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        mid.next = null;
        return root;
    }

    private ListNode root(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode quick = head;
        ListNode prev = null;

        while (quick.next != null && quick.next.next != null) {
            prev = slow;
            slow = slow.next;
            quick = quick.next.next;
        }

        if (prev != null) prev.next = null;
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(9);
        System.out.println(new Q109_SortedLinkedList2BinarySearchTree().sortedListToBST(l1));
    }

}
