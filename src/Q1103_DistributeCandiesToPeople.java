import java.util.Arrays;

/**
 * @author gengchao05 create on 2020/03/05
 */
public class Q1103_DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        if (num_people <= 0) {
            return new int[0];
        }

        int[] result = new int[num_people];
        int remainCandies = candies;
        int index = 0;

        while (remainCandies > 0) {
            int usedCandies = Math.min(remainCandies, index + 1);
            result[(index++) % num_people] += usedCandies;
            remainCandies -= usedCandies;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Q1103_DistributeCandiesToPeople().distributeCandies(7, 4)));
    }
}
