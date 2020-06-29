package tree;

/**
 * @author gengchao05 create on 2020/06/29
 */
public class Q226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        invertTree(root.right);
        invertTree(root.left);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }

}
