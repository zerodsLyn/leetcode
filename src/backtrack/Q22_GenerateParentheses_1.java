package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author zerodsLyn create on 2019/05/08
 */
public class Q22_GenerateParentheses_1 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        track(n, sb, 0, 0);
        return result;
    }

    public void track(int n, StringBuilder sb, int left, int right) {
        if (sb.toString().length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (left == right) {
            sb.append("(");
            track(n, sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        } else if (left == n){
            sb.append(")");
            track(n, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append("(");
            track(n, sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(")");
            track(n, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q22_GenerateParentheses_1().generateParenthesis(3));
    }
}
