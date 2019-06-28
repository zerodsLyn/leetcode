import java.util.Stack;

/**
 * @author gengchao05
 * create on 2019/06/2
 *
 * Given two strings S and T, return if they are equal when both are
 * typed into empty text editors. # means a backspace character.
 *
 */
public class Q844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();

        int length1 = S.length();
        int length2 = T.length();
        int maxLength = length1 > length2 ? length1 : length2;

        for (int i = 0; i < maxLength; i++) {
            if (i < length1) {
                char achar = S.charAt(i);
                if ('#' == achar) {
                    if (!s.isEmpty()) {
                        s.pop();
                    }
                } else {
                    s.push(achar);
                }
            }

            if (i < length2) {
                char achar = T.charAt(i);
                if ('#' == achar) {
                    if (!t.isEmpty()) {
                        t.pop();
                    }
                } else {
                    t.push(achar);
                }
            }
        }

        StringBuilder stringBuilder1 = new StringBuilder();
        while (!s.isEmpty()) {
            stringBuilder1.append(s.pop());
        }

        StringBuilder stringBuilder2 = new StringBuilder();
        while (!t.isEmpty()) {
            stringBuilder2.append(t.pop());
        }

        return stringBuilder1.toString().equals(stringBuilder2.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Q844_BackspaceStringCompare().backspaceCompare("ab##", "c#d#"));
        System.out.println(new Q844_BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Q844_BackspaceStringCompare().backspaceCompare("a##c", "#a#c"));
        System.out.println(new Q844_BackspaceStringCompare().backspaceCompare("a#c", "b"));
        System.out.println(new Q844_BackspaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
