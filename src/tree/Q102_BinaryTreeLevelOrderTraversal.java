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

        List<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);

        while (curLevel.size() > 0) {
            List<TreeNode> tmp = new LinkedList<>();

            List<Integer> curLevelNum = new LinkedList<>();
            for (TreeNode node : curLevel) {
                curLevelNum.add(node.val);
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }

            curLevel = tmp;
            if (curLevelNum.size() > 0) {
                result.add(curLevelNum);
            }
        }

        return result;
    }
}
