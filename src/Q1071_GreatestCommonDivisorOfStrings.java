/**
 * @author zerodsLyn create on 2020/03/12
 */
public class Q1071_GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }

        if (str2.length() == 1) {
            if (str1.charAt(0) == str2.charAt(0)) {
                return str2;
            }

            return str1;
        }

        int gcd = gcd(str1.length(), str2.length());
        if (gcd == 1) {
            return "";
        } else {
            String sub = str2.substring(0, gcd);
            int num1 = str1.length() / gcd;
            int num2 = str2.length() / gcd;
            for (int i = 0; i < num1; i++) {
                if (i < num2) {
                    if (str2.indexOf(sub, i * gcd) != str1.indexOf(sub, i * gcd)) {
                        return "";
                    }
                }
                else {
                    if (str1.indexOf(sub, i * gcd) == -1) {
                        return "";
                    }
                }
            }

            return sub;
        }
    }

    private int gcd(int length1, int length2) {
        int mod = length1 % length2;
        if (mod == 0) {
            return length2;
        }

        return gcd(length2, mod);
    }

    public static void main(String[] args) {
        System.out.println(new Q1071_GreatestCommonDivisorOfStrings().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new Q1071_GreatestCommonDivisorOfStrings().gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(new Q1071_GreatestCommonDivisorOfStrings().gcdOfStrings("LEET", "CODE"));
        System.out.println(new Q1071_GreatestCommonDivisorOfStrings().gcdOfStrings("ABCDEF", "ABC"));
    }
}
