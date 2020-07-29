package tree;

/**
 * @author zerodsLyn create on 2020/06/29
 */
public class Q104_MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null ) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
