package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zerodsLyn
 * created on 2020/9/24
 */
public class Q501_FindModeInBinarySearchTree {
    private List<Integer> modes;
    private int cur;
    private int curTimes;
    private int lastTimes;

    public int[] findMode(TreeNode root) {
        modes = new LinkedList<>();
        inOrder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++)
            res[i] = modes.get(i);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (lastTimes == 0)
            lastTimes = 1;
        if (root.val != cur)
            curTimes = 0;
        cur = root.val;
        curTimes++;
        if (curTimes == lastTimes)
            modes.add(cur);
        if (curTimes > lastTimes) {
            lastTimes = curTimes;
            modes.clear();
            modes.add(cur);
        }
        inOrder(root.right);
    }
}
