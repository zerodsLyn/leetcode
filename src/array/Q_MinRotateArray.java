package array;

/**
 * @author gengchao05 create on 2020/07/22
 */
public class Q_MinRotateArray {

    public int minArray(int[] numbers) {
        int n = numbers.length;
        int loIndex = 0, hiIndex = n - 1;

        while (loIndex < hiIndex) {
            int mid = (loIndex + hiIndex) / 2;
            if ((mid == 0 && numbers[mid] < numbers[mid + 1]) ||
                    (numbers[mid] < numbers[mid + 1] && numbers[mid] < numbers[mid - 1])) {
                return numbers[mid];
            }
            if (numbers[mid] <= numbers[hiIndex]) {
                hiIndex = mid - 1;
            } else {
                loIndex = mid + 1;
            }
        }

        return numbers[loIndex];
    }

    public static void main(String[] args) {
        Q_MinRotateArray q_minRotateArray = new Q_MinRotateArray();
        System.out.println(q_minRotateArray.minArray(new int[] {3, 1, 1}));
        System.out.println(q_minRotateArray.minArray(new int[] {1, 3, 3}));
        System.out.println(q_minRotateArray.minArray(new int[] {1, 3, 5}));
        System.out.println(q_minRotateArray.minArray(new int[] {1, 3, 4, 5}));
        System.out.println(q_minRotateArray.minArray(new int[] {3, 4, 5, 1}));
        System.out.println(q_minRotateArray.minArray(new int[] {5, 1, 3, 4}));
        System.out.println(q_minRotateArray.minArray(new int[] {3, 4, 5, 1, 2}));
        System.out.println(q_minRotateArray.minArray(new int[] {2, 2, 2, 0, 1}));
    }

}
