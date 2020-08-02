package tree;

/**
 * @author zerodsLyn
 * created on 2020/7/18
 */
public class Q114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        root.left = null;
        flatten(left);
        TreeNode right = root.right;
        if (left != null) {
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        }
        flatten(right);
    }
}
