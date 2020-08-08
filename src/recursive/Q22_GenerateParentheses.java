package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author zerodsLyn create on 2019/05/08
 */
public class Q22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        addParanthesis(ans, "", 0, 0, n);
        return ans;
    }

    public void addParanthesis(List<String> list, String curStr, int countL, int countR, int n) {
        if (curStr.length() == n * 2) {
            list.add(curStr);
            return;
        }

        if (countL < n) {
            addParanthesis(list, curStr + "(", countL + 1, countR, n);
        }

        if (countR < countL) {
            addParanthesis(list, curStr + ")", countL, countR + 1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q22_GenerateParentheses().generateParenthesis(3));
    }
}
