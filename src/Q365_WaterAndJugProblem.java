/**
 * @author gengchao05 create on 2020/03/21
 */
public class Q365_WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y) {
            return false;
        }
        if(x == 0 || y == 0) {
            return z == Math.max(x, y) || z == 0;
        }
        return z % getGCD(x, y) == 0;
    }

    public int getGCD(int a, int b) {
        return a % b == 0 ? b : getGCD(b, a % b);
    }
}
