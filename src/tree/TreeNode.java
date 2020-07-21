package tree;

/**
 * @author zerodsLyn create on 2020/02/28
 */
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x) { val = x; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
    }
}
