package other;

import java.util.LinkedList;
import java.util.List;

public class SayAndLook {

    static class StringConcatenator {
        LinkedList<String> elems;

        StringConcatenator() {
            elems = new LinkedList<>();
        }

        void add(String number, char digit) {
            elems.add(String.format("%s(%c)", number, digit));
        }

        void removeLast() {
            elems.removeLast();
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            elems.forEach(sb::append);

            return sb.toString();
        }
    }

    public static List<String> lookAndSay(String input) {
        var results = new LinkedList<String>();
        lookAndSay(results, new StringConcatenator(), input, 0, input.length() - 1);

        return results;
    }

    public static void lookAndSay(List<String> results, StringConcatenator concat, String input, int a, int z) {
        if (a > z) {
            results.add(concat.toString());
            return;
        } else if (z - a == 0) {
            return;
        }

        for (int i = a + 1; i <= z; ++i) {
            concat.add(input.substring(a, i), input.charAt(i));
            lookAndSay(results, concat, input, i + 1, z);
            concat.removeLast();
        }
    }
    public static void main(String [] args) {
        var list = lookAndSay("123456");

        list.forEach(System.out::println);
    }
    
}
