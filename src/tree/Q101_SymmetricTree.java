package tree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author zerodsLyn
 * created on 2020/5/31
 */
public class Q101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null) return isSymmetric(root.left, root.right);
        return false;
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            return left.val == right.val && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        }
        return left == null && right == null;
    }
}
