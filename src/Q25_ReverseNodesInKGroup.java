/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @author zerodsLyn create on 2020/03/13
 */
public class Q25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode start = head;
        ListNode end = head;
        ListNode nextStart = head;
        ListNode lastEnd = null;

        while (start != null) {
            int curNum = 1;
            while (curNum < k) {
                end = end.next;
                if (end == null) {
                    if (newHead == null) {
                        return head;
                    } else {
                        return newHead;
                    }
                }
                curNum++;
            }
            nextStart = end.next;
            reverseLinkedList(lastEnd, start, end, nextStart);
            if (newHead == null) {
                newHead = end;
            }
            lastEnd = start;
            start = nextStart;
            end = start;
        }

        return newHead;
    }

    private void reverseLinkedList(ListNode lastEnd, ListNode start, ListNode end, ListNode nextStart) {
        ListNode cur = start;
        ListNode next = start.next;
        while (next != nextStart) {
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }

        if (lastEnd != null) {
            lastEnd.next = end;
        }
        start.next = nextStart;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(new Q25_ReverseNodesInKGroup().reverseKGroup(listNode, 1));

        ListNode listNode1 = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(new Q25_ReverseNodesInKGroup().reverseKGroup(listNode, 2));

        ListNode listNode2 = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(new Q25_ReverseNodesInKGroup().reverseKGroup(listNode, 3));

        ListNode listNode3 = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(new Q25_ReverseNodesInKGroup().reverseKGroup(listNode, 4));

        ListNode listNode4 = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(new Q25_ReverseNodesInKGroup().reverseKGroup(listNode, 5));

    }
}
