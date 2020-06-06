/**
 * https://leetcode-cn.com/problems/sqrtx/
 * @author zerodsLyn create on 2020/05/25
 */
public class Q67_SqrtX {
    public int mySqrt(int x) {
        if (x == 1) return x;

        int lo = 2, hi = x / 2, mid;

        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            int result = x / mid;
            if (result == mid) return mid;
            else if (result < mid) hi = mid - 1;
            else lo = mid + 1;
        }

        return hi;
    }
}
