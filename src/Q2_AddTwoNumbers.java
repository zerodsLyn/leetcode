/**
 * 2.Add Two Numbers
 * <p>
 * You are given two 【non-empty】 linked lists representing two 【non-negative】 integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 *
 * @author gengchao05 create on 2019/04/07
 */
public class Q2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 添加哨兵
        ListNode result = new ListNode(0);
        ListNode start = result;
        int carry = 0;
        do {
            int sum = l1.val + l2.val + carry;

            int remainder = sum % 10;
            carry = sum / 10;
            result.next = new ListNode(remainder);
            result = result.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null);

        while (l1 != null) {
            int sum = l1.val + carry;
            int remainder = sum % 10;
            carry = sum / 10;
            result.next = new ListNode(remainder);
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            int remainder = sum % 10;
            carry = sum / 10;
            result.next = new ListNode(remainder);
            result = result.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null && carry != 0) {
            result.next = new ListNode(1);
        }

        return start.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(4);

        System.out.println(new Q2_AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}
