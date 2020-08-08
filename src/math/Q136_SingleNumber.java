package math;

/**
 * https://leetcode-cn.com/problems/single-number/
 * @author zerodsLyn
 * created on 2020/5/14
 */
public class Q136_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
