package tree;

/**
 * @author zerodsLyn
 * created on 2020/7/17
 */
public class Q99_RecoverBST {
    TreeNode first, second, pred;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        // 前序遍历
        inOrder(root.left);
        // 中序遍历
        if (pred != null && pred.val > root.val) {
            second = root;
            if (first == null) first = pred;
            else return;
        }
        pred = root;

        inOrder(root.right);
    }
}
