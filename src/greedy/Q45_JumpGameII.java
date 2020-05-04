package greedy;

/**
 * @author zerodsLyn
 * created on 2020/5/4
 */
public class Q45_JumpGameII {
    public int jump(int[] nums) {
        int index = 0, hup = 0;

        while (index < nums.length - 1) {
            int curOffSet = nums[index];
            if (index + curOffSet >= nums.length - 1) return hup + 1;

            int nextIndex = index + 1, maxOffset = 0;
            for (int i = index + 1; i <= index + curOffSet; i++) {
                if (i + nums[i] >= maxOffset) {
                    maxOffset = i + nums[i];
                    nextIndex = i;
                }
            }

            hup++;
            index = nextIndex;
        }

        return hup;
    }
}
