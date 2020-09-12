package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * @author zerodsLyn
 * created on 2020/9/12
 */
public class Q637_AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Double> res = new LinkedList<>();

        if (root == null) return res;

        LinkedList<TreeNode> curNodes = new LinkedList<>();
        curNodes.add(root);
        while (curNodes.size() > 0) {
            double sum = 0;
            int size = curNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = curNodes.poll();
                sum += node.val;
                if (node.left != null) curNodes.add(node.left);
                if (node.right != null) curNodes.add(node.right);
            }
            res.add(sum / size);
        }

        return res;
    }
}
