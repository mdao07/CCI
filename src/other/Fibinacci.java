package other;

import java.util.Arrays;

public class Fibinacci {

    public static int[] exec(int n) {
        //if (n < 2) {

        //}

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
