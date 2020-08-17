package tree;

/**
 * @author zerodsLyn
 * created on 2020/8/7
 */
public class Q100_IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (q == null) return false;
        else if (p == null) return false;

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
