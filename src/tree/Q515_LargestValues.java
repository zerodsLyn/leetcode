package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/8/3
 */
public class Q515_LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                max = Math.max(max, node.val);
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            result.add(max);
        }

        return result;
    }
}
