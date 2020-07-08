package tree;

/**
 * @author zerodsLyn create on 2020/07/06
 */
public class Q437_PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int paths(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + paths(root.left, sum - root.val) + paths(root.right, sum - root.val);
    }
}
