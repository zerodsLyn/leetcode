/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author zerodsLyn create on 2019/04/10
 */
public class Q4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = null;
        if (nums1 == null && nums2 == null) {
            return 0.0;
        } else if (nums1 == null || nums1.length == 0) {
            result = nums2;
        } else if (nums2 == null || nums2.length == 0) {
            result = nums1;
        }
        if (result != null) {
            int index = result.length / 2;
            if (result.length % 2 == 0) {
                return (result[index] + result[index - 1]) / 2.0;
            } else {
                return result[index];
            }
        }

        int m = nums1.length;
        int n = nums2.length;
        // 如果是奇数，则两个索引的和正好为中位数所在的顺序，比如共15个数字，和为8，则A[i-1]和B[j-1]较大值为左值
        // 如果是偶数，中位数为两个数的平均数，比如共16个数字，则中位数的顺序是8和9
        // 此时两个索引的和正好为中位数前一个值所在的顺序，说明两个值的顺序是9和10，说明两个数字较小值为右值
        int mid = (m + n + 1) / 2;

        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int i;
        int j;
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax) {
            i = (iMax + iMin) / 2;
            j = mid - i;
            if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else {
                int maxLeft;
                // i = 0 代表左半边只有第二个数组的值，直接取最大值
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                // i = m 代表右半边只有第二个数组的值，直接取最小值
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }

    public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        int[] result = null;
        if (nums1 == null && nums2 == null) {
            return 0.0;
        } else if (nums1 == null || nums1.length == 0) {
            result = nums2;
        } else if (nums2 == null || nums2.length == 0) {
            result = nums1;
        }
        if (result != null) {
            int index = result.length / 2;
            if (result.length % 2 == 0) {
                return (result[index] + result[index - 1]) / 2.0;
            } else {
                return result[index];
            }
        }

        int m = nums1.length;
        int n = nums2.length;
        // 如果是奇数，则两个索引的和正好为中位数所在的顺序，说明两个值其中的较大值为中位数
        // 如果是偶数，中位数为两个数的平均数，比如共16个数字，则中位数的顺序是8和9
        // 此时两个索引的和正好为中位数前一个值所在的顺序，说明两个值较大值为中位数的左值
        int mid = (m + n + 1) / 2;
        boolean even = (m + n) % 2 == 0;

        int[] A = null;
        int lenA = -1;
        int[] B = null;
        // 数组2的值都大于数组1的值
        if (nums1[m - 1] <= nums2[0]) {
            A = nums1;
            lenA = m;
            B = nums2;

        }
        // 数组1的值都大于数组2的值
        else if (nums2[n - 1] <= nums1[0]) {
            A = nums2;
            lenA = n;
            B = nums1;
        }

        // 两个数组的大小关系是线性的,中位数在边界位
        if (A != null) {
            if (even) {
                if (mid == lenA) {
                    return (A[lenA - 1] + B[0]) / 2.0;
                } else if (mid > lenA) {
                    return (B[mid - lenA] + B[mid - lenA - 1]) / 2.0;
                } else {
                    return (A[mid] + A[mid - 1]) / 2.0;
                }
            } else {
                if (mid == lenA) {
                    return B[0];
                } else if (mid > lenA) {
                    return B[mid - lenA];
                } else {
                    return A[mid];
                }
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 3};
        int[] nums2 = new int[]{2, 4, 4, 4, 5, 6, 9};
        System.out.println(new Q4_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
