package array;

/**
 * @author zerodsLyn
 * created on 2020/8/29
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Q80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) return 0;

        int result = 1;
        int curNum = nums[0];
        int curCount = 1;
        int prev = 0;
        int curIndex = 1;
        while (curIndex < len) {
            int cur = nums[curIndex];
            if (cur == curNum) {
                if (curCount < 2) {
                    curIndex++;
                    curCount++;
                    result++;
                } else {
                    prev = curIndex;
                    int tmp = curIndex + 1;
                    while (tmp < len && nums[tmp] == curNum) {
                        tmp++;
                    }
                    if (tmp == len) break;
                    else {
                        int gap = tmp - prev;
                        for (int i = tmp; i < len; i++) {
                            nums[i - gap] = nums[i];
                        }
                        len -= gap;
                    }
                }
            } else {
                curNum = cur;
                curCount = 1;
                curIndex++;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q80_RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(new Q80_RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(new Q80_RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1,1,1,1,1}));
        System.out.println(new Q80_RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{1}));
    }
}
