package tree;

/**
 * @author zerodsLyn
 * created on 2020/7/18
 */
public class Q114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        if (left == null) return root;

        if (right == null) {
            root.right = left;
            root.left = null;
            return root;
        } else {
            TreeNode last = left;
            while (last.right != null) {
                last = last.right;
            }

            last.right = right;
            root.right = left;
            root.left = null;
            return root;
        }
    }
}
