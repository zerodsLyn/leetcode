package array;

import java.util.Arrays;

/**
 * @author zerodsLyn create on 2020/03/20
 */
public class Q_MinKNums {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }

        Pair pair;
        int left = 0;
        int right = arr.length - 1;
        while (true) {
            pair = findPivot(arr, left, right);
            if (pair.start <= k && k <= pair.end) {
                break;
            } else if (k < pair.start) {
                right = pair.start - 1;
            } else {
                left = pair.end;
            }
        }

        int[] result = new int[k];
        System.arraycopy(arr, 0, result, 0, k);

        return result;
    }

    public Pair findPivot(int[] arr, int left, int right) {
        int pivot = arr[left];

        int lt = left;
        int equal = left + 1;
        int gt = right + 1;
        while (equal < gt) {
            if (arr[equal] == pivot) {
                equal++;
            } else if (arr[equal] < pivot) {
                swap(arr, lt + 1, equal);
                lt++;
                equal++;
            } else {
                swap(arr, equal, --gt);
            }
        }

        swap(arr, left, lt);
        return new Pair(lt, gt);
    }

    private static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 1)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 2)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 3)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 4)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 5)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 6)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 7)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 8)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 9)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,1,1,2,4,4,1,3,3,2}, 10)));

        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 1)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 2)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 3)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 4)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 5)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 6)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 7)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 8)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 9)));
        System.out.println(Arrays.toString(new Q_MinKNums().getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 10)));

//        System.out.println(Arrays.toString(new array.Q_MinKNums().getLeastNumbers(new int[]{3,2,1}, 2)));
//        System.out.println(Arrays.toString(new array.Q_MinKNums().getLeastNumbers(new int[]{0,1,2,1}, 1)));
//        System.out.println(Arrays.toString(new array.Q_MinKNums().getLeastNumbers(new int[]{0,1,2,1}, 2)));
//        System.out.println(Arrays.toString(new array.Q_MinKNums().getLeastNumbers(new int[]{0,1,2,1}, 3)));
//        System.out.println(Arrays.toString(new array.Q_MinKNums().getLeastNumbers(new int[]{0,1,2,1}, 4)));
    }
}
