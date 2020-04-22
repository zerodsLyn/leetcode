import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/4/22
 */
public class Q199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> curLevelNodes = new LinkedList<>();
        curLevelNodes.add(root);

        boolean add = true;
        int start = 0, end = 0;
        while (add) {
            result.add(curLevelNodes.get(end).val);

            add = false;
            int nextEnd = end;
            for (int i = start; i <= end; i++) {
                TreeNode node = curLevelNodes.get(i);
                if (node.left != null) {
                    curLevelNodes.add(node.left);
                    nextEnd++;
                    add = true;
                }
                if (node.right != null) {
                    curLevelNodes.add(node.right);
                    nextEnd++;
                    add = true;
                }
            }
            start = end + 1;
            end = nextEnd;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t4;

        System.out.println(new Q199_BinaryTreeRightSideView().rightSideView(t1));
    }

}
