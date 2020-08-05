package array;

import java.util.Arrays;

/**
 * @author zerodsLyn create on 2020/07/02
 */
public class Q189_RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) return;
        int count = 0, index = 0, prev = nums[0];
        int maxDivider = maxDivider(len, k);
        boolean circular = false;
        int circularCount = 0;
        if (maxDivider != 1) {
            circular = true;
            circularCount = len / maxDivider;
        }
        int curCircleCount = 0;

        while (count < len) {
            index = (index + k) % len;
            int tmp = nums[index];
            nums[index] = prev;
            prev = tmp;
            count++;

            if (circular) {
                curCircleCount++;
                if (curCircleCount == circularCount) {
                    index++;
                    curCircleCount = 0;
                    prev = nums[index];
                }
            }
        }
    }

    private int maxDivider(int a, int b) {
        if (a < b) return maxDivider(b, a);
        if (a % b == 0) return b;
        return maxDivider(b, a-b);
    }

    public static void main(String[] args) {
        int[] result = new int[] {1,2,3,4,5,6};
        Q189_RotateArray q189RotateArray = new Q189_RotateArray();
        q189RotateArray.rotate(result, 4);
        System.out.println(Arrays.toString(result));

        System.out.println(q189RotateArray.maxDivider(10, 2));
        System.out.println(q189RotateArray.maxDivider(12, 2));
        System.out.println(q189RotateArray.maxDivider(12, 8));
        System.out.println(q189RotateArray.maxDivider(12, 10));
        System.out.println(q189RotateArray.maxDivider(12, 6));

    }
}
