import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST
 * such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28

 * @author gengchao05 create on 2020/02/28
 */
public class Q653_TwoSumIV_Input_Is_A_BST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> numbers = new ArrayList<>();
        mid(root, numbers);

        int i = 0;
        int j = numbers.size() - 1;

        while (i < j) {
            int x = numbers.get(i);
            int y = numbers.get(j);

            int sum = x + y;
            if (sum == k) {
                return true;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    private void mid(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        mid(root.left, values);
        values.add(root.val);
        mid(root.right, values);
    }
}
