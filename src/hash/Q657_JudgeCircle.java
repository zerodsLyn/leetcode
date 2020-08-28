package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zerodsLyn
 * created on 2020/8/28
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class Q657_JudgeCircle {
    public boolean judgeCircle(String moves) {
        int len;
        if (moves == null || (len = moves.length()) == 0) return true;

        Map<Character, Integer> move2Count = new HashMap<>(4);
        for (int i = 0; i < len; i++) {
            char c = moves.charAt(i);
            if (move2Count.containsKey(c)) {
                move2Count.put(c, move2Count.get(c) + 1);
            } else {
                move2Count.put(c, 1);
            }
        }

        int r = move2Count.getOrDefault('R', 0);
        int l = move2Count.getOrDefault('L', 0);
        int u = move2Count.getOrDefault('U', 0);
        int d = move2Count.getOrDefault('D', 0);

        return r == l && u == d;
    }
}
