package tree;

/**
 * @author gengchao05 create on 2020/06/29
 */
public class Q538_ConvertBST {
    int lastVal = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.right);

        root.val = root.val + lastVal;
        lastVal = root.val;

        convertBST(root.left);

        return root;
    }
}
