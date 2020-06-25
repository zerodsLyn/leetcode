package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zerodsLyn
 * created on 2020/6/25
 */
public class Q139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strs = new HashSet<>(wordDict);
        // 可以类比于背包问题
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && strs.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }
}
