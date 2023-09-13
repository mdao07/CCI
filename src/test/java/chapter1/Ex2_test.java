package chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static chapter1.Ex2.isPermutationA;
import static chapter1.Ex2.isPermutationB;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex2_test {

    @ParameterizedTest
    @MethodSource("getPositiveArguments")
    void isPermutationA_positiveScenarios(String str1, String str2) {
        boolean result = isPermutationA(str1, str2);
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("getNegativeArguments")
    void isPermutationA_negativeScenarios(String str1, String str2) {
        boolean result = isPermutationA(str1, str2);
        assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("getPositiveArguments")
    void isPermutationB_positiveScenarios(String str1, String str2) {
        boolean result = isPermutationB(str1, str2);
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("getNegativeArguments")
    void isPermutationB_negativeScenarios(String str1, String str2) {
        boolean result = isPermutationB(str1, str2);
        assertFalse(result);
    }

    private static Stream<Arguments> getPositiveArguments() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("abcdef", "defabc"),
                Arguments.of("abc def", "d efabc")
        );
    }

    private static Stream<Arguments> getNegativeArguments() {
        return Stream.of(
                Arguments.of(null, "abc"),
                Arguments.of("abc", null),
                Arguments.of(null, null),
                Arguments.of("abc", "abcdef"),
                Arguments.of("abcdef", "degabc")
        );
    }
}
