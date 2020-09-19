package tree;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * @author zerodsLyn
 * created on 2020/9/19
 */
public class Q404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves(root.left) +
                        sumOfLeftLeaves(root.right);
            } else {
                return sumOfLeftLeaves(root.left) +
                        sumOfLeftLeaves(root.right);
            }
        } else {
            return sumOfLeftLeaves(root.right);
        }
    }
}
