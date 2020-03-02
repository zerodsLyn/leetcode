/**
 * @author gengchao05 create on 2019/04/07
 */
public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        if (next == null) {
            return val + "";
        } else {
            return val + "->" + next.toString();
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);

        System.out.println(listNode);
    }
}
