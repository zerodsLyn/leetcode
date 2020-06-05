import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @author zerodsLyn create on 2020/06/01
 */
public class Q1431_KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int len;
        if (candies == null || (len = candies.length) == 0) return new ArrayList<>(0);

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, candies[i]);
        }

        List<Boolean> result = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (max == candies[i] || candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}
