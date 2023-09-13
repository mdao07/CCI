package chapter1;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 *
 * EXAMPLE
 *
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 */
public class Ex5 {

    private static boolean insert(String src, String tgt) {
        final int length = tgt.length();
        boolean changed = false;

        for (int i = 0, j = 0; j < length; ++i) {
            if (src.charAt(i) != tgt.charAt(j)) {
                if (changed) {
                    return false;
                }

                changed = true;
            } else {
                ++j;
            }
        }

        return true;
    }

    private static boolean replace(String src, String tgt) {
        final int length = src.length();
        boolean changed = false;

        for (int i = 0; i < length; ++i) {
            if (src.charAt(i) != tgt.charAt(i)) {
                if (changed) {
                    return false;
                }

                changed = true;
            }
        }

        return true;
    }

    public static boolean isOneWay(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        int comp = Math.abs(s1.length() - s2.length());

        return switch (comp) {
            case -1 -> insert(s2, s1);
            case 0 -> replace(s1, s2);
            case 1 -> insert(s1, s2);
            default -> false;
        };
    }

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "bales";

        System.out.println(isOneWay(s1, s2));
    }
}
