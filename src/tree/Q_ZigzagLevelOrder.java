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

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        LinkedList<TreeNode> curNodes = new LinkedList<>();
        curNodes.add(root);
        boolean reverse = false;
        Stack<TreeNode> stack = new Stack<>();
        while (curNodes.size() > 0) {
            int size = curNodes.size();
            List<Integer> singleRow = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = curNodes.poll();
                if (reverse) {
                    stack.push(node);
                    if (i == size - 1) {
                        while (!stack.isEmpty()) {
                            singleRow.add(stack.pop().val);
                        }
                    }
                } else {
                    singleRow.add(node.val);
                }
                if (node.left != null) curNodes.offer(node.left);
                if (node.right != null) curNodes.offer(node.right);
            }
            reverse = !reverse;
            result.add(singleRow);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(new Q_ZigzagLevelOrder().zigzagLevelOrder2(node1));
    }
}
