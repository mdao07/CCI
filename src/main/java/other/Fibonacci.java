package other;

import java.util.Arrays;

public class Fibonacci {

    public static int[] exec(int n) {
        int arr[] = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < n; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr;
    }

    public static void main(String [] args) {
        var arr = exec(10);

        System.out.println(Arrays.toString(arr));
    }
}
