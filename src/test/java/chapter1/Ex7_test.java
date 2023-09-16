package chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static chapter1.Ex7.rotateMatrix;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Ex7_test {

    @ParameterizedTest
    @MethodSource("get4x4Matrix")
    void rotateMatrix_evenMatrix(int [][] actual, int[][] expected) {
        rotateMatrix(actual);

        for (int row = 0; row < actual.length; ++row) {
            assertArrayEquals(expected[row], actual[row]);
        }
    }

    @ParameterizedTest
    @MethodSource("get5x5Matrix")
    void rotateMatrix_oddMatrix(int [][] actual, int[][] expected) {
        rotateMatrix(actual);

        for (int row = 0; row < actual.length; ++row) {
            assertArrayEquals(expected[row], actual[row]);
        }
    }

    private static Stream<Arguments> get4x4Matrix() {
        int [][] original = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };

        int [][] expected = {

                {4, 8, 12, 16},
                {3, 7, 11, 15},
                {2, 6, 10, 14},
                {1, 5, 9,  13}
        };

        return Stream.of(Arguments.of(original, expected));
    }

    private static Stream<Arguments> get5x5Matrix() {
        int [][] original = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int [][] expected = {
                {5, 10, 15, 20, 25},
                {4, 9,  14, 19, 24},
                {3, 8,  13, 18, 23},
                {2, 7,  12, 17, 22},
                {1, 6,  11, 16, 21}
        };

        return Stream.of(Arguments.of(original, expected));
    }
}
