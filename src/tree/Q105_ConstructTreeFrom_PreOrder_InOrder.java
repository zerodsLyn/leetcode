package tree;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author zerodsLyn
 * created on 2020/5/22
 */
public class Q105_ConstructTreeFrom_PreOrder_InOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart < preEnd) return null;
        if (preStart == preEnd) return new TreeNode(preEnd);

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int inOrderRootIndex = findIndex(rootVal, inorder, inStart, inEnd);
        int preEndIndex = preStart + (inOrderRootIndex - inStart);

        root.left = buildTree(preorder, preStart + 1, preEndIndex,
                inorder, inStart, inOrderRootIndex - 1
        );
        root.right = buildTree(preorder, preEndIndex + 1, preEnd,
                inorder, inOrderRootIndex + 1, inEnd
        );
        return root;
    }

    private int findIndex(int rootVal, int[] inorder, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootVal) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};

        System.out.println(new Q105_ConstructTreeFrom_PreOrder_InOrder().buildTree1(preOrder, inOrder));
    }
}
