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
        } else if (a == z) {
            return;
        }

        for (int i = a + 1; i <= z; ++i) {
            concat.add(input.substring(a, i), input.charAt(i));
            lookAndSay(results, concat, input, i + 1, z);
            concat.removeLast();
        }
    }

    public static List<String> lookAndSay2(String str) {
        var generator = new CombinationGenerator();
        return generator.generate(str);
    }

    static class CombinationGenerator {
        String strNum;
        LinkedList<String> elem;
        List<String> list;

        CombinationGenerator() {
            elem = new LinkedList<>();
            list = new LinkedList<>();
        }

        public List<String> generate(String strNum) {
            if (strNum == null) {
                return new LinkedList<>();
            }

            this.strNum = strNum;
            elem.clear();
            list.clear();
            generate(0, strNum.length() - 1);

            return list;
        }

        private void generate(int a, int b) {
            if (a > b) {
                list.add(String.join("", elem));
                return;
            } else if  (a == b) {
                return;
            }

            /*
            for (int i = b; i > a; --i) {
                elem.add(String.format("%s(%s)", strNum.substring(a, i), strNum.charAt(i)));
                generate(i + 1, b);
                elem.removeLast();
            }
            */

            for (int i = a + 1; i <= b; ++i) {
                elem.add(String.format("%s(%s)", strNum.substring(a, i), strNum.charAt(i)));
                generate(i + 1, b);
                elem.removeLast();
            }
        }

    }

    public static void main(String [] args) {
        String strNum = "123456";

        List<String> list = lookAndSay(strNum);
        list.forEach(System.out::println);

        System.out.println("--------------------------------");

        list = lookAndSay2(strNum);
        list.forEach(System.out::println);
    }
    
}
