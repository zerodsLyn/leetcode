package tree;

/**
 * @author zerodsLyn
 * created on 2020/6/21
 */
public class Q124_MaxPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return max;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }

        if (root.left == null) {
            int r = maxPathSumHelper(root.right);
            int curMax = r > 0 ? r + root.val : root.val;
            max = Math.max(Math.max(max, curMax), r);
            return curMax;
        } else if (root.right == null) {
            int l = maxPathSumHelper(root.left);
            int curMax = l > 0 ? l + root.val : root.val;
            max = Math.max(Math.max(max, curMax), l);
            return curMax;
        } else {
            int l = maxPathSumHelper(root.left);
            int r = maxPathSumHelper(root.right);
            int maxSub = Math.max(l, r);
            int curMax = maxSub > 0 ? maxSub + root.val : root.val;

            max = Math.max(max, Math.max(Math.max(maxSub, curMax), l + r + root.val));
            return curMax;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(-2);
        TreeNode right = new TreeNode(-3);
        /*TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode20 = new TreeNode(20);*/
        root.left = left;
        root.right = right;

        TreeNode node1 = new TreeNode(1);
        left.left = node1;
        left.right = new TreeNode(3);

        right.left = new TreeNode(-2);

        node1.left = new TreeNode(-1);
        System.out.println(new Q124_MaxPathSum().maxPathSum(root));
    }
}
