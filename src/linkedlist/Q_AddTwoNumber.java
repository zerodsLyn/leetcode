package linkedlist;

import doublepointer.ListNode;

/**
 * @author zerodsLyn
 * created on 2020/5/5
 */
public class Q_AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(-1);
        ListNode tmp = result;
        int flag = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum += flag;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            flag = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            sum = 0;
        }

        if (flag > 0) {
            tmp.next = new ListNode(flag);
        }

        return result.next;
    }
}
