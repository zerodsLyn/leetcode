package dp;

/**
 * @author zerodsLyn create on 2020/06/05
 */
public class Q70_ClimbStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
