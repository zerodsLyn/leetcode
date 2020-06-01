package tree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author zerodsLyn
 * created on 2020/5/31
 */
public class Q101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (right == null && left != null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
