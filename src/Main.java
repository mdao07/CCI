import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int p = 3;
    private static int fillSet(String num, int a, int b, Set<String> set, LinkedList<String> list) {
        if (a == b) {
            return 0;
        }

        String sub = num.substring(a, b);
        int curNum = Integer.parseInt(sub);

        if (curNum % p == 0) {
            String res = (a + 1) + "|" + sub + "|" + b;
            set.add(res);
            list.add(res);
        }
        int count = 1;
        count += fillSet(num, a, b - 1, set, list);
        count += fillSet(num, a + 1, b, set, list);

        return count;
    }
    public static void main(String[] args) {
        /*
        String num = "4831318";
        var set = new TreeSet<String>();
        var list = new LinkedList<String>();
        int count = fillSet(num, 0, num.length(), set, list);

        var newList = list.stream().sorted().toList();

        System.out.println(count);
        System.out.println(set.size());
        System.out.println(set);
        System.out.println(newList.size());
        System.out.println(newList);
        */
        for (int i = 100; i > 0; --i) {
            System.out.print(i + " ");
        }

    }
}