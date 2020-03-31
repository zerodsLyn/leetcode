/**
 * @author zerods
 * @version 1.0 2020/3/31
 */
public class Q912_SortAnArray {
    public int[] sortArray(int[] nums) {
        int max = -50000;
        int min = 50000;

        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        int buckets = max - min + 1;
        int[] countArray = new int[buckets];
        for (int num : nums) {
            countArray[num - min] = countArray[num - min] + 1;
        }

        int j = 0;
        for (int i = 0; i < countArray.length; i++) {
            int count = countArray[i];
            while (count-- > 0) {
                nums[j++] = i + min;
            }
        }

        return nums;
    }
}
