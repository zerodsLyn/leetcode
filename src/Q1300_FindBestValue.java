import java.util.Arrays;

/**
 * @author zerodsLyn create on 2020/06/14
 */
public class Q1300_FindBestValue {
    public int findBestValue(int[] arr, int target) {
        int preSum = 0, sum = 0, flag = 0, cur = target / arr.length;
        while (true) {
            preSum = sum;
            sum = 0;
            flag = 0;
            for (int value : arr) {
                if (value > cur) {
                    sum += cur;
                } else {
                    sum += value;
                    flag++;
                }
            }
            if (flag == arr.length) {
                return cur;
            }
            if (sum >= target) {
                break;
            }
            cur++;

        }

        return Math.abs(target - preSum) > Math.abs(target - sum) ? cur : cur - 1;
    }
}
