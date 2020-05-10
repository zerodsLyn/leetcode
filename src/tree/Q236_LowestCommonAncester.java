package tree;

/**
 * @author zerodsLyn
 * created on 2020/5/10
 */
public class Q236_LowestCommonAncester {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // 如果在一边，必定有一个返回null
        // 如果不在一遍，那么必定都不为空
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            // 这种情况不会走到
            return null;
        }
    }
}
