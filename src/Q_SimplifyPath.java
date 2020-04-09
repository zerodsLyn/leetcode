/**
 * @author gengchao05 create on 2020/04/09
 */
public class Q_SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i].trim();
            if (cur.length() > 0) {
                if (cur.equals("..")) {
                    if (result.length() > 0) {
                        int j = result.length() - 1;
                        while (result.charAt(j) != '/') {
                            result.deleteCharAt(j);
                            j--;
                        }
                        result.deleteCharAt(j);
                    }
                } else if (cur.equals(".")) {
                } else {
                    result.append('/');
                    result.append(cur);
                }
            }
        }
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Q_SimplifyPath().simplifyPath("/home/"));
        System.out.println(new Q_SimplifyPath().simplifyPath("/../"));
        System.out.println(new Q_SimplifyPath().simplifyPath("/home//foo/"));
        System.out.println(new Q_SimplifyPath().simplifyPath("/a/./b/../../c/"));
        System.out.println(new Q_SimplifyPath().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Q_SimplifyPath().simplifyPath("/a//b////c/d//././/.."));
    }
}
