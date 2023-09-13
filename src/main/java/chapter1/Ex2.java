package chapter1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class Ex2 {

    public static boolean isPermutationA (String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        final int length = s1.length();
        var hm = new HashMap<Character, Integer>();
        char curChar;

        for (int i = 0; i < length; ++i) {
            curChar = s1.charAt(i);
            int value = hm.computeIfAbsent(curChar, k -> 0);
            hm.put(curChar, value + 1);
        }

        for (int i = 0; i < length; ++i) {
            curChar = s2.charAt(i);

            if (!hm.containsKey(curChar)) {
                return false;
            }

            int value = hm.get(curChar);

            if (value == 1) {
                hm.remove(curChar);
            } else {
                hm.put(curChar, value - 1);
            }
        }

        return true;
    }

    public static boolean isPermutationB (String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        var charArr1 = s1.toCharArray();
        var charArr2 = s2.toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        for (int i = 0; i < charArr1.length; ++i) {
            if (charArr1[i] != charArr2[i]) {
                return false;
            }
        }

        return true;
    }
}
