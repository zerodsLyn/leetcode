package tree;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author zerodsLyn
 * created on 2020/5/7
 */
public class Q572_SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s == null && t != null) return false;
        else if (s != null && t == null) return false;
        else return equal(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        else if (s == null && t != null) return false;
        else if (s != null && t == null) return false;
        else return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }
}
