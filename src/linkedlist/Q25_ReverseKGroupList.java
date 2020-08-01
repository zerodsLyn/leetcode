package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn create on 2020/07/29
 */
public class Q25_ReverseKGroupList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

//        System.out.println(new Q25_ReverseKGroupList().reverseKGroup(listNode, 2));
//        System.out.println(new Q25_ReverseKGroupList().reverseKGroup(listNode, 3));
//        System.out.println(new Q25_ReverseKGroupList().reverseKGroup(listNode, 4));
        System.out.println(new Q25_ReverseKGroupList().reverseKGroup(listNode, 5));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode result = null;
        ListNode prevEnd = null, curHead = head, curEnd = head;
        ListNode nextHead;
        int i = 1;
        while (curEnd != null) {
            if (i < k) {
                curEnd = curEnd.next;
                i++;
            } else {
                i = 1;
                nextHead = curEnd.next;
                if (result == null) result = curEnd;
                reverseLinkedList(curHead, curEnd);
                if (prevEnd != null) prevEnd.next = curEnd;
                prevEnd = curHead; curHead = nextHead; curEnd = curHead;
            }
        }

        if (result == null) return head;
        prevEnd.next = curHead;
        return result;
    }

    private void reverseLinkedList(ListNode head, ListNode end) {
        if (head == null) return;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != end) {
            ListNode nextNext = next.next;
            next.next = cur;
            cur = next;
            next = nextNext;
        }
        head.next = null;
    }
}
