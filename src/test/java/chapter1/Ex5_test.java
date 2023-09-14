package chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static chapter1.Ex5.isOneWay;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex5_test {

    @ParameterizedTest
    @MethodSource("getPositiveArguments")
    void isOneWay_positiveScenarios(String s1, String s2) {
        boolean result = isOneWay(s1, s2);
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("getNegativeArguments")
    void isOneWay_negativeScenarios(String s1, String s2) {
        boolean result = isOneWay(s1, s2);
        assertFalse(result);
    }

    private static Stream<Arguments> getPositiveArguments() {
        return Stream.of(
                Arguments.of("pale", "pale"),
                Arguments.of("pale", "bale"),
                Arguments.of("bale", "pale"),
                Arguments.of("pale", "pales"),
                Arguments.of("pales", "pale")
        );
    }

    private static Stream<Arguments> getNegativeArguments() {
        return Stream.of(
                Arguments.of("pale", null),
                Arguments.of(null, "pale"),
                Arguments.of(null, null),
                Arguments.of("abcd", "avzd"),
                Arguments.of("pale", "bales"),
                Arguments.of("short string", "way way longer string")
        );
    }
}
