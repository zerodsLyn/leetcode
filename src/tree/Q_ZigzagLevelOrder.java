package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1027/
 * @author zerods
 * @version 1.0 2020/4/4
 */
public class Q_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<TreeNode> otherNodes = new Stack<>();
        nodes.push(root);

        LinkedList<Integer> curLayerValues = new LinkedList<>();
        boolean left = true;
        while (!nodes.empty()) {
            while (!nodes.empty()) {
                TreeNode curNode = nodes.pop();
                curLayerValues.add(curNode.val);
                if (left) {
                    if (curNode.left != null) {
                        otherNodes.push(curNode.left);
                    }
                    if (curNode.right != null) {
                        otherNodes.push(curNode.right);
                    }
                } else {
                    if (curNode.right != null) {
                        otherNodes.push(curNode.right);
                    }
                    if (curNode.left != null) {
                        otherNodes.push(curNode.left);
                    }
                }
            }

            result.add(curLayerValues);

            curLayerValues = new LinkedList<>();
            nodes = otherNodes;
            left = !left;
            otherNodes = new Stack<>();
        }

        return result;
    }
}
