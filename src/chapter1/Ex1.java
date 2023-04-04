package chapter1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Is Unique:
 *  A) Implement an algorithm to determine if a string has all unique characters.
 *  B) What if you cannot use additional data structures?
 */
public class Ex1 {

    public static boolean isUniqueA (String str) {
        if (str == null) {
            return true;
        }

        var hs = new HashSet<Character>();

        for (int i = 0; i < str.length(); ++i) {
            if (!hs.add(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isUniqueB (String str) {
        if (str == null) {
            return true;
        }

        var charArr = str.toCharArray();
        Arrays.sort(charArr);

        for (int i = 1; i < charArr.length; ++i) {
            if (charArr[i] == charArr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main (String [] args) {
        String s1 = "abcdeff";

        System.out.println(isUniqueA(s1));
        System.out.println(isUniqueB(s1));
    }
}
