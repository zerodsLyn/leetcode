package str;

/**
 * @author zerodsLyn create on 2020/03/16
 */
public class Q_CompressStringLCCI {
    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }


        char curChar = S.charAt(0);
        int curCount = 1;
        StringBuilder newStr = new StringBuilder();
        newStr.append(curChar);

        for (int i = 1; i < S.length(); i++) {
            if (curChar == S.charAt(i)) {
                curCount++;
            } else {
                newStr.append(curCount);
                curChar = S.charAt(i);
                newStr.append(curChar);
                curCount = 1;
            }

            if (i == S.length() - 1) {
                newStr.append(curCount);
            }
        }

        return newStr.length() >= S.length() ? S : newStr.toString();
    }
}
