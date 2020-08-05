package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zerodsLyn create on 2020/07/28
 */
public class Q144_PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.pop();
            result.add(cur.val);
            if (cur.right != null) nodes.push(cur.right);
            if (cur.left != null) nodes.push(cur.left);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(new Q144_PreOrderTraversal().preorderTraversal(node1));
    }

}
