import java.util.*;
import java.util.List;

public class StringTester {
    public static List<Character> get_sorted_keys(
        HashMap<Character, Integer> my_dict
    ) {
        List<Character> sortedKeys = new ArrayList<>(my_dict.keySet());
        Collections.sort(sortedKeys);
        return sortedKeys;
    }

    public static boolean isAllCharacterUnique(String sIn) {
        HashMap<Character, Integer> my_dict = StringTester.breakdown(sIn);
        List<Character> sortedKeys = StringTester.get_sorted_keys(my_dict);

        for (Character key : sortedKeys) {
            Integer count = my_dict.get(key);
            if (count > 1) { return false; }
        }
        return true;
    }
    static HashMap<Character, Integer> breakdown (String string) {
        HashMap<Character, Integer> my_dict = (
            new HashMap<Character, Integer>()
        );
        for (int i = 0; i < string.length(); i++) {
            Character ch = string.charAt(i);
            if (!my_dict.containsKey(ch)) {
                my_dict.put(ch, 1);
            } else {
                Integer count = my_dict.get(ch);
                my_dict.put(ch, count + 1);
            }
        }
        return my_dict;
    }
    public static boolean isPermutation(String sIn1, String sIn2) {
        HashMap<Character, Integer> dict1 = StringTester.breakdown(sIn1);
        HashMap<Character, Integer> dict2 = StringTester.breakdown(sIn2);
        if (dict1.size() != dict2.size()) { return false; }

        List<Character> sorted_keys1 = StringTester.get_sorted_keys(dict1);
        List<Character> sorted_keys2 = StringTester.get_sorted_keys(dict2);

        for (int k = 0; k < sorted_keys1.size(); k++) {
            Character char1 = sorted_keys1.get(k);
            Character char2 = sorted_keys2.get(k);
            if (char1 != char2) { return false; }

            Integer count1 = dict1.get(char1);
            Integer count2 = dict2.get(char2);
            if (!count1.equals(count2)) { return false; }
        }
        return true;
    }

    public static void test() {
        System.out.println(StringTester.isAllCharacterUnique(
            "abcdefghijklmnopqrstuvABC"
        ));
        System.out.println(StringTester.isAllCharacterUnique(
            "abcdefgghijklmnopqrstuvABC"
        ));
        System.out.println(StringTester.isPermutation("@ab", "a@b"));
        System.out.println(StringTester.isPermutation("abcd", "bcdA"));
    }
}
