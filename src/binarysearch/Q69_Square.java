package binarysearch;

/**
 * @author zerodsLyn
 * created on 2020/5/9
 */
public class Q69_Square {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int start = 1, end = x / 2 + 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new Q69_Square().mySqrt(4));
        System.out.println(new Q69_Square().mySqrt(8));
        System.out.println(new Q69_Square().mySqrt(9));
        System.out.println(new Q69_Square().mySqrt(24));
        System.out.println(new Q69_Square().mySqrt(2147395599));
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
    }
}
