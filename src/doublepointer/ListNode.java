package doublepointer;

/**
 * @author zerodsLyn create on 2019/04/07
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {}

    public ListNode(int x) { val = x; }

    public ListNode(int x, ListNode next) { val = x; this.next = next;}

    @Override
    public String toString() {
        return val + "->" + (next == null ? "/" : next.toString());
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);

        System.out.println(listNode);
    }
}
