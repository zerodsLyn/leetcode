package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @author zerodsLyn
 * created on 2020/9/4
 */
public class Q257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String str : leftPaths) {
            result.add(root.val + "->" + str);
        }
        for (String str : rightPaths) {
            result.add(root.val + "->" + str);
        }

        return result;
    }
}
