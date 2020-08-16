package tree;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author zerodsLyn
 * created on 2020/5/5
 */
public class Q98_ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = true, right = true;
        if (root.left != null) left = max(root.left) < root.val && isValidBST(root.left);
        if (root.right != null) right = min(root.right) > root.val && isValidBST(root.right);
        return left && right;
    }

    private int min(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    private int max(TreeNode root) {
        int max = root.val;
        while (root.right != null) {
            max = root.right.val;
            root = root.right;
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode20 = new TreeNode(20);
        treeNode10.left = treeNode5;
        treeNode10.right = treeNode15;
        treeNode15.left = treeNode6;
        treeNode15.right = treeNode20;

        System.out.println(new Q98_ValidBinarySearchTree().isValidBST(treeNode10));
    }
}
