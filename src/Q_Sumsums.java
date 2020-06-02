/**
 * @author zerodsLyn
 * created on 2020/6/2
 */
public class Q_Sumsums {
    public int sumNums(int n) {
        return n == 1 ? 1 : sumNums(n - 1) + n;
    }
}
