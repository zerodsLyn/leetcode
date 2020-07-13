package math;

/**
 * @author zerodsLyn
 * created on 2020/7/12
 */
public class Q461_HammingDistance {
    public int hammingDistance(int x, int y) {
        int result = 0;
        while (x != 0 || y != 0) {
            int a = x & 1;
            int b = y & 1;
            int c = a ^ b;
            result += c;
            x = x >>> 1;
            y = y >>> 1;
        }

        return result;
    }
}
