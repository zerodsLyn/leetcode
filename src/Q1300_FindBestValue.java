/**
 * @author zerodsLyn create on 2020/06/14
 */
public class Q1300_FindBestValue {
    public int findBestValue(int[] arr, int target) {
        int preSum = 0, sum = 0, flag = 0, cur = target/arr.length;//cur为枚举变量，从平均值开始可以降低一点时间复杂度
        while(true){
            preSum = sum;
            sum = 0;
            flag = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > cur) sum += cur;
                else{
                    sum += arr[i];
                    flag++;//记录跳入此分支的次数
                }
            }
            if(flag == arr.length) return cur;//当数组中的数全比cur小，直接返回当前cur值就好（相当于数组中的最大值）
            if(sum >= target) break;
            cur++;

        }
        return Math.abs(target-preSum) > Math.abs(target-sum) ? cur : cur - 1;
    }
}
