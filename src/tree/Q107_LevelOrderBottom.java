package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zerodsLyn
 * created on 2020/8/8
 */
public class Q107_LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Stack<List<Integer>> stack = new Stack<>();
        LinkedList<TreeNode> curRow = new LinkedList<>();
        curRow.push(root);

        while (!curRow.isEmpty()) {
            int size = curRow.size();
            List<Integer> singleRow = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = curRow.pop();
                singleRow.add(node.val);
                if (node.left != null) curRow.offer(node.left);
                if (node.right != null) curRow.offer(node.right);
            }
            stack.add(singleRow);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
