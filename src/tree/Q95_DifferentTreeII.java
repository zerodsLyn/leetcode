package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/7/21
 */
public class Q95_DifferentTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new LinkedList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateTreesHelper(start, i - 1);
            List<TreeNode> rightNodes = generateTreesHelper(i + 1, end);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    result.add(new TreeNode(i, leftNode, rightNode));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new Q95_DifferentTreeII().generateTrees(3);
        System.out.println(treeNodes);
    }
}
