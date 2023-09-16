package chapter1;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes, write a method to
 * rotate the image by 90 degrees.
 *
 * Can you do this in place?
 *
 */
public class Ex7 {

    public static void rotateMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        final int length = matrix.length;
        for (int [] arr : matrix) {
            if (arr == null || arr.length != length) {
                return;
            }
        }

        int aux;
        for (int a = 0, z = length - 1; a < z; ++a, --z) {
            for (int ai = a, zi = z; ai < z; ++ai, --zi) {
                aux = matrix[a][ai];
                matrix[a][ai] = matrix[ai][z];
                matrix[ai][z] = matrix[z][zi];
                matrix[z][zi] = matrix[zi][a];
                matrix[zi][a] = aux;
            }
        }
    }
}
