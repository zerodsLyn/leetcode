package binarysearch;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * @author zerodsLyn
 * created on 2020/5/11
 */
public class Q50_MyPow {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(x, n + 1) / x;
            }
            return 1 / myPow(x, -n);
        }

        if (n == 1) return x;
        if (n == 2) return x * x;

        if ((n & 0x1) == 0) {
            return myPow(myPow(x, n / 2), 2);
        } else {
            return x * myPow(x, n - 1);
        }
    }
}
