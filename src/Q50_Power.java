/**
 * https://leetcode-cn.com/problems/powx-n/
 * @author zerodsLyn create on 2020/06/04
 */
public class Q50_Power {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return (1 / myPow(x, Integer. MAX_VALUE)) / x;
            } else {
                return  1 / myPow(x, -1 * n);
            }
        }

        if (n % 2 == 0) {
            double result = myPow(x, n / 2);
            return result * result;
        }
        return x * myPow(x, n - 1) * 1.0;
    }
}
