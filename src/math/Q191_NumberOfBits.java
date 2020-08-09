package math;

/**
 * @author zerodsLyn
 * created on 2020/8/9
 */
public class Q191_NumberOfBits {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n & 0x1);
            n = n >>> 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q191_NumberOfBits().hammingWeight(0b11111111111111111111111111111101));
    }
}
