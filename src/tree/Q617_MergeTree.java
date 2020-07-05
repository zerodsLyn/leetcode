package tree;

/**
 * @author zerodsLyn
 * created on 2020/7/5
 */
public class Q617_MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);

        TreeNode result = new TreeNode(t1.val + t2.val);
        result.left = left;
        result.right = right;
        return result;
    }
}
