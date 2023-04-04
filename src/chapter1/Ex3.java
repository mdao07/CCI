package chapter1;

import java.util.Arrays;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 *
 * EXAMPLE
 *
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 */
public class Ex3 {

    private static final char [] space = {'%', '2', '0'};
    public static void URLify (char [] text) {
        if (text == null) {
            return;
        }

        int id1, id2;
        id1 = id2 = text.length - 1;

        for (--id1; id1 != id2 && text[id1] == ' '; --id1);

        for (; id1 >= 0; --id1) {
            if (text[id1] == ' ') {
                for (int i = space.length - 1; i >= 0; --i, --id2) {
                    text[id2] = space[i];
                }
            } else {
                text[id2] = text[id1];
                --id2;
            }
        }
    }

    public static void main (String [] args) {
        var arr = "Mr John Smith    ".toCharArray();

        System.out.println(Arrays.toString(arr));
        URLify(arr);
        System.out.println(Arrays.toString(arr));
    }
}
