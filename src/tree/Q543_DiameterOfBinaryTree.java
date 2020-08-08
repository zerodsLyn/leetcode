package tree;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author zerodsLyn create on 2020/03/10
 */
public class Q543_DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + maxHeight(root.right);
        }

        if (root.right == null) {
            return 1 + maxHeight(root.left);
        }

        return Math.max(2 + maxHeight(root.left) + maxHeight(root.right),
                        Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + maxHeight(root.right);
        }

        if (root.right == null) {
            return 1 + maxHeight(root.left);
        }

        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(-7);
        TreeNode three = new TreeNode(-3);
        one.left = two;
        one.right = three;

        TreeNode t_minus9 = new TreeNode(-9);
        TreeNode t_minus3 = new TreeNode(-3);
        three.left = t_minus9;
        three.right = t_minus3;

        TreeNode t_9 = new TreeNode(9);
        TreeNode t_minus7 = new TreeNode(-7);
        t_minus9.left = t_9;
        t_minus9.right = t_minus7;

        System.out.println(new Q543_DiameterOfBinaryTree().diameterOfBinaryTree(one));
    }
}
