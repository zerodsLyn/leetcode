package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author zerodsLyn
 * created on 2020/5/13
 */
public class Q102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            List<Integer> curRow = new LinkedList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodes.poll();
                curRow.add(cur.val);
                if (cur.left != null) nodes.offer(cur.left);
                if (cur.right != null) nodes.offer(cur.right);
            }
            result.add(curRow);
        }

        return result;
    }
}
