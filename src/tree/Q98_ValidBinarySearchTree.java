package tree;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author zerodsLyn
 * created on 2020/5/5
 */
public class Q98_ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        int midVal = root.val;
        boolean leftValid = root.left == null || (midVal > findMax(root.left) && isValidBST(root.left));
        boolean rightValid = root.right == null || (midVal < findMin(root.right) && isValidBST(root.right));

        return leftValid && rightValid;
    }

    public int findMax(TreeNode treeNode) {
        int max = treeNode.val;
        while (treeNode != null) {
            max = treeNode.val;
            treeNode = treeNode.right;
        }
        return max;
    }

    public int findMin(TreeNode treeNode) {
        int min = treeNode.val;
        while (treeNode != null) {
            min = treeNode.val;
            treeNode = treeNode.left;
        }
        return min;
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
