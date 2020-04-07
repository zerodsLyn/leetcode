package doublepointer;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @author zerods
 * @version 1.0 2020/4/7
 */
public class Q142_LinkedListCycleII {
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        if (head == null || head.next == null) {
            return null;
        }

        HashSet<ListNode> nodes = new HashSet<>();
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                break;
            }
        }

        if (quick == null || quick.next == null) {
            return null;
        }

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            nodes.add(slow);
            if (slow == quick) {
                break;
            }
        }

        while (!nodes.contains(head)) {
            head = head.next;
        }

        return head;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        if (head == null || head.next == null) {
            return null;
        }

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                break;
            }
        }

        if (quick == null || quick.next == null) {
            return null;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;

        /*ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);*/

        System.out.println(new Q142_LinkedListCycleII().detectCycle(l1).val);
    }
}
