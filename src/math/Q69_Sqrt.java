package math;

/**
 * @author zerodsLyn
 * created on 2020/8/4
 */
public class Q69_Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 3) return 1;

        int l = 2, r = x / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) return mid;
            else if (mid < x / mid) l = mid + 1;
            else r = mid - 1;
        }
        return l - 1;
    }
}
