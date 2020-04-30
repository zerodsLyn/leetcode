package doublepointer;

/**
 * @author zerodsLyn
 * created on 2020/4/30
 */
public class Q202_HappyNumber {
    public boolean isHappy(int n) {
        int val = square(n);
        int slowSum = val, quickSum = square(val);
        while (quickSum != slowSum) {
            if (slowSum == 1 || quickSum == 1) {
                return true;
            }
            slowSum = square(slowSum);
            quickSum = square(square(quickSum));
        }

        return slowSum == 1;
    }

    int square(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow((n % 10), 2);
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Q202_HappyNumber().isHappy(19));
        System.out.println(new Q202_HappyNumber().isHappy(1));
        System.out.println(new Q202_HappyNumber().isHappy(10));
    }
}
