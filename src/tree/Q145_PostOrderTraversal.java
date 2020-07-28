package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zeordsLyn create on 2020/07/28
 */
public class Q145_PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode cur = root;
        TreeNode lastVisitNode = null;
        while (cur != null || !nodes.isEmpty()) {
            if (cur != null) {
                nodes.push(cur);
                cur = cur.left;
            } else {
                cur = nodes.peek();
                if (cur.right == null || cur.right == lastVisitNode) {
                    result.add(cur.val);
                    nodes.pop();
                    lastVisitNode = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(new Q145_PostOrderTraversal().postorderTraversal(node1));
    }
}
