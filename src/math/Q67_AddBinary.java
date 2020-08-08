package math;

/**
 * @author zerodsLyn create on 2020/06/23
 */
public class Q67_AddBinary {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (bLen > aLen) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        aLen = a.length();
        bLen = b.length();

        int i  = aLen - 1, j = bLen - 1;
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while (i >= 0 && j >= 0) {
            char ac = a.charAt(i--);
            char bc = b.charAt(j--);
            int ai = val(ac);
            int bi = val(bc);
            int sum = ai + bi + flag;
            if (sum == 3) {
                flag = 1;
                sum = 1;
            } else if (sum == 2) {
                flag = 1;
                sum = 0;
            } else if (sum == 1) {
                flag = 0;
                sum = 1;
            } else {
                flag = 0;
                sum = 0;
            }

            sb.append(sum);
        }

        while (i >= 0 || flag == 1) {
            char ac = '0';
            if (i >= 0) {
                ac = a.charAt(i);
                i--;
            }
            int ai = val(ac);
            int sum = ai + flag;
            if (sum == 2) {
                flag = 1;
                sum = 0;
            } else if (sum == 1) {
                flag = 0;
                sum = 1;
            } else {
                flag = 0;
                sum = 0;
            }

            sb.append(sum);
        }

        return sb.reverse().toString();
    }

    private int val(char c) {
        if (c == '1') {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q67_AddBinary().addBinary("1010", "1011"));
        System.out.println(new Q67_AddBinary().addBinary("11", "1"));
        System.out.println(new Q67_AddBinary().addBinary("100","110010"));
    }
}
