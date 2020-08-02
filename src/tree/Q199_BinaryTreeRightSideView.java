package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/4/22
 */
public class Q199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> curNodes = new LinkedList<>();
        curNodes.add(root);
        while (!curNodes.isEmpty()) {
            int size = curNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = curNodes.poll();
                if (i == size - 1) result.add(node.val);
                if (node.left != null) curNodes.offer(node.left);
                if (node.right != null) curNodes.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t4;

        System.out.println(new Q199_BinaryTreeRightSideView().rightSideView(t1));
    }

}
