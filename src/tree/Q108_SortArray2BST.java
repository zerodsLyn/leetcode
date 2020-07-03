package tree;

/**
 * @author zerodsLyn
 * created on 2020/7/3
 */
public class Q108_SortArray2BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sort(nums, 0, nums.length - 1);
    }


    private TreeNode sort(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return new TreeNode(nums[lo]);

        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sort(nums, lo, mid - 1);
        root.right = sort(nums, mid + 1, hi);
        return root;
    }
}
