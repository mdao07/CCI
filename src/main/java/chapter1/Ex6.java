package chapter1;

/**
 *
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 *
 */
public class Ex6 {

    public static String compress(String text) {
        if (text == null) {
            return text;
        }

        final int length = text.length();
        var sb = new StringBuilder();
        char c;
        int prevI;

        for (int i = 0; i < length;) {
            prevI = i;
            c = text.charAt(i);

            for (++i; i < length && text.charAt(i) == c; ++i);

            sb.append(c);
            sb.append(i - prevI);
        }

        if (sb.length() >= text.length()) {
            return text;
        }

        return sb.toString();
    }
}
