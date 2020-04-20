/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author zerodsLyn create on 2019/04/07
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
