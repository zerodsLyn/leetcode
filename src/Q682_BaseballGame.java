import java.util.Stack;

/**
 * @author gengchao05
 * create on 2019/06/27
 *
 * https://leetcode-cn.com/problems/baseball-game/
 */
public class Q682_BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> points = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if ("+".equals(op)) {
                Integer lastPeek = points.pop();
                int sum = points.peek() + lastPeek;
                points.push(lastPeek);
                points.push(sum);
            } else if ("D".equals(op)) {
                Integer peek = points.peek();
                points.push(peek * 2);
            } else if ("C".equals(op)) {
                points.pop();
            } else {
                points.push( Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!points.isEmpty()) {
            sum += points.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q682_BaseballGame().calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(new Q682_BaseballGame().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
