package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zerodsLyn create on 2020/07/13
 */
public class Q350_IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int size1 = nums1.length, size2 = nums2.length;

        List<Integer> result = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < size1 && i2 < size2) {
            if (nums1[i1] == nums2[i2]) {
                result.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            }
        }

        int[] interNums = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            interNums[i] = result.get(i);
        }
        return interNums;
    }
}
