package array;

/**
 * @author zerodsLyn create on 2020/07/22
 */
public class Q_MinRotateArray {

    public int minArray(int[] numbers) {
        return findMin(numbers, 0, numbers.length - 1);
    }

    private int findMin(int[] numbers, int loIndex, int hiIndex) {
        if (loIndex >= hiIndex) return numbers[loIndex];
        int mid = (loIndex + hiIndex) / 2;
        // 找到了极值点
        if (numbers[mid] > numbers[mid + 1]) return numbers[mid + 1];
        if (mid > loIndex && numbers[mid] < numbers[mid - 1]) return numbers[mid];

        // 先增后减再增 mid在第一个增区间，最小值在第二个增区间
        if (numbers[mid] > numbers[hiIndex]) return findMin(numbers, mid + 1, hiIndex);
        // ①递增 ②先增后减再增 mid在第二个增区间，最小值在第二个增区间，但是需要取前半区
        else if (numbers[mid] < numbers[hiIndex]) return findMin(numbers, loIndex, mid - 1);

        else if (numbers[mid] > numbers[loIndex]) return numbers[loIndex];
        else if (numbers[mid] < numbers[loIndex]) return findMin(numbers, loIndex, mid - 1);
        else return Math.min(findMin(numbers, loIndex, mid - 1), findMin(numbers, mid + 1, hiIndex));
    }

    public static void main(String[] args) {
        Q_MinRotateArray q_minRotateArray = new Q_MinRotateArray();
        System.out.println(q_minRotateArray.minArray(new int[] {2,0,0,1,2}));
        System.out.println(q_minRotateArray.minArray(new int[] {3,3,3,3,3,3,3,3,1,3}));
        System.out.println(q_minRotateArray.minArray(new int[] {1, 3}));
        System.out.println(q_minRotateArray.minArray(new int[] {10, 1, 10, 10, 10}));
        System.out.println(q_minRotateArray.minArray(new int[] {3, 3, 1, 3}));
        System.out.println(q_minRotateArray.minArray(new int[] {3, 1, 1}));
        System.out.println(q_minRotateArray.minArray(new int[] {1, 3, 3}));
        System.out.println(q_minRotateArray.minArray(new int[] {1, 3, 5}));
        System.out.println(q_minRotateArray.minArray(new int[] {1, 3, 4, 5}));
        System.out.println(q_minRotateArray.minArray(new int[] {3, 4, 5, 1}));
        System.out.println(q_minRotateArray.minArray(new int[] {5, 1, 3, 4}));
        System.out.println(q_minRotateArray.minArray(new int[] {3, 4, 5, 1, 2}));
        System.out.println(q_minRotateArray.minArray(new int[] {2, 2, 2, 0, 1}));
        System.out.println(q_minRotateArray.minArray(new int[] {2, 2, 2, 2, 3, 4}));
    }

}
