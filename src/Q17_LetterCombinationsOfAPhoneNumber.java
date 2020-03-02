import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author gengchao05 create on 2020/03/02
 */
public class Q17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, List<Character>> num2Strs = new HashMap<>();
        init(num2Strs);

        List<String> result = new ArrayList<>();
        permute(digits, num2Strs, result);
        return result;
    }

    void permute(String digits, Map<Character, List<Character>> num2Strs, List<String> result) {
        LinkedList<Character> track = new LinkedList<>();
        backtrack(digits, num2Strs, track, result, 0);
    }

    void backtrack(String digits, Map<Character, List<Character>> num2Strs, LinkedList<Character> track,  List<String> result, int index) {
        if (track.size() == digits.length()) {
            char[] chars = new char[track.size()];
            int i = 0;
            for (Character character : track) {
                chars[i++] = character;
            }
            result.add(new String(chars));
            return;
        }

        char o = digits.charAt(index);
        List<Character> characters = num2Strs.get(o);
        for (Character character : characters) {
            track.add(character);
            backtrack(digits, num2Strs, track, result, index + 1);
            track.removeLast();
        }
    }

    private void init(Map<Character, List<Character>> num2Str) {
        List<Character> strs2 = new ArrayList<>();
        strs2.add('a');
        strs2.add('b');
        strs2.add('c');
        num2Str.put('2', strs2);

        List<Character> strs3 = new ArrayList<>();
        strs3.add('d');
        strs3.add('e');
        strs3.add('f');
        num2Str.put('3', strs3);

        List<Character> strs4 = new ArrayList<>();
        strs4.add('g');
        strs4.add('h');
        strs4.add('i');
        num2Str.put('4', strs4);

        List<Character> strs5 = new ArrayList<>();
        strs5.add('j');
        strs5.add('k');
        strs5.add('l');
        num2Str.put('5', strs5);

        List<Character> strs6 = new ArrayList<>();
        strs6.add('m');
        strs6.add('n');
        strs6.add('o');
        num2Str.put('6', strs6);

        List<Character> strs7 = new ArrayList<>();
        strs7.add('p');
        strs7.add('r');
        strs7.add('q');
        strs7.add('s');
        num2Str.put('7', strs7);

        List<Character> strs8 = new ArrayList<>();
        strs8.add('t');
        strs8.add('u');
        strs8.add('v');
        num2Str.put('8', strs8);

        List<Character> strs9 = new ArrayList<>();
        strs9.add('w');
        strs9.add('x');
        strs9.add('y');
        strs9.add('z');
        num2Str.put('9', strs9);
    }

    public static void main(String[] args) {
        new Q17_LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }
}
