/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author zerods
 * @version 1.0 2020/3/30
 */
public class Q_LastNumInACircle {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Q_LastNumInACircle().lastRemaining(5, 3));
        System.out.println(new Q_LastNumInACircle().lastRemaining(10, 17));
        System.out.println(new Q_LastNumInACircle().lastRemaining(88,10));
    }
}
