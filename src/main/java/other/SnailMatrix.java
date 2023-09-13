package other;

public class SnailMatrix {

    public static void snailPrint(int [][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rowsLength = matrix.length;
        int colsLength = matrix[0].length;
        for (int [] arr : matrix) {
            if (arr == null || arr.length != colsLength) {
                return;
            }
        }

        int rUp = 0;
        int rDn = rowsLength - 1;
        int cLt = 0;
        int cRt = colsLength - 1;

        for (int i; rUp <= rDn; ++rUp, --rDn, ++cLt, --cRt) {
            for (i = cLt; i < cRt; ++i) {
                System.out.print(matrix[rUp][i] + " ");
            }

            for (i = rUp; i < rDn; ++i) {
                System.out.print(matrix[i][cRt] + " ");
            }

            for (i = cRt; i > cLt; --i) {
                System.out.print(matrix[rDn][i] + " ");
            }

            for (i = rDn; i > rUp; --i) {
                System.out.print(matrix[i][cLt] + " ");
            }

            if (rowsLength == colsLength && cLt == cRt) {
                int mid = colsLength / 2;
                System.out.println(matrix[mid][mid]);
            }
        }
    }

    public static void main (String [] args) {
        int [][] matrix = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
            };

        snailPrint(matrix);
    }

}
