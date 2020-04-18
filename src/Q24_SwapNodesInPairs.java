/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author zerodsLyn create on 2020/03/06
 */
public class Q24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        int even = 1;

        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        ListNode tmp;
        while (next != null) {
            if (even == 1) {
                if (prev == null) {
                    head = next;
                    tmp = next.next;
                    next.next = cur;
                    cur.next = tmp;

                    tmp =next.next;
                    prev = cur;
                    cur = next;
                    next = tmp;
                } else {
                    tmp = next.next;
                    prev.next = next;
                    next.next = cur;
                    cur.next = tmp;

                    tmp =next.next;
                    prev = cur;
                    cur = next;
                    next = tmp;

                }
            }

            prev = cur;
            cur = next;
            next = cur.next;
            even = 1 - even;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = null;

        System.out.println(new Q24_SwapNodesInPairs().swapPairs(head1));

    }
}
