package chapter1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 *
 * EXAMPLE
 *
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class Ex4 {

    public static boolean isPalindromePermutation1(String text) {
        if (text == null) {
            return false;
        }

        String trimmed = text.toLowerCase().replaceAll("\s+", "");
        var hm = new HashMap<Character, Integer>();
        trimmed.chars().forEach(i -> hm.compute((char)i, (k, v) -> v == null ? 1 : v + 1));
        long oddsCount = hm.values().stream()
                .filter(val -> (val % 2) != 0)
                .count();

        return oddsCount <= 1;
    }

    public static boolean isPalindromePermutation2(String text) {
        if (text == null) {
            return false;
        }

        String trimmed = text.toLowerCase().replaceAll("\s+", "");
        var chars = trimmed.toCharArray();
        Arrays.sort(chars);

        final int length = chars.length;
        boolean hasOdd = false;
        char c;
        int prevI;
        for (int i = 0; i < length;) {
            prevI = i;
            c = chars[i];

            for (++i; i < length && chars[i] == c; ++i);

            if ((i - prevI) % 2 != 0) {
                if (hasOdd) {
                    return false;
                }

                hasOdd = true;
            }
        }

        return true;
    }
}
