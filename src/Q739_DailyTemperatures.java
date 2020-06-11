import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author zerodsLyn create on 2020/06/11
 */
public class Q739_DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int len;
        if (T == null || (len = T.length) == 0) return T;

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = T[i];
            for (int j = i + 1; j < len; j++) {
                if (T[j] > cur) {
                    result[i] = j - i;
                    break;
                }
            }
        }

        return result;
    }

    public int[] dailyTemperatures_2(int[] T) {
        int len;
        if (T == null || (len = T.length) == 0) return T;

        Map<Integer, Integer> num2Index = new HashMap<>(T.length);
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int cur = T[i];
            if (i < len - 1) {
                int minIndex = len;
                for (int j = cur + 1; j <= 100; j++) {
                    if (num2Index.containsKey(j)) {
                        int index = num2Index.get(j);
                        if (index > i && index < minIndex) {
                            result[i] = num2Index.get(j) - i;
                            minIndex = index;
                        }

                    }
                }
            }
            num2Index.put(T[i], i);
        }

        return result;
    }
}
