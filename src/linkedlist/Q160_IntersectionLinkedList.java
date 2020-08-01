package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn
 * created on 2020/8/1
 */
public class Q160_IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tmpA = headA, tmpB = headB;
        while (tmpA != tmpB) {
            if (tmpB == null) tmpB = headA;
            else if (tmpA == null) tmpA = headB;
            else  {
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
        }

        return tmpA;
    }
}
