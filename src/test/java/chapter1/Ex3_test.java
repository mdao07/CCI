package chapter1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static chapter1.Ex3.URLify;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Ex3_test {

    @ParameterizedTest
    @MethodSource("getPositiveArguments")
    void URLify_positiveScenarios(char [] original, char [] expected) {
        URLify(original);
        assertArrayEquals(expected, original);
    }

    @ParameterizedTest
    @MethodSource("getNeutralArguments")
    void URLify_neutralScenarios(char [] original, char [] expected) {
        URLify(original);
        assertArrayEquals(expected, original);
    }

    private static Stream<Arguments> getPositiveArguments() {
        return Stream.of(
                Arguments.of("Mr John Smith    ".toCharArray(), "Mr%20John%20Smith".toCharArray()),
                Arguments.of("Don't look back    ".toCharArray(), "Don't%20look%20back".toCharArray())
        );
    }

    private static Stream<Arguments> getNeutralArguments() {
        return Stream.of(
                "string_with_no_spaces",
                "Try%20the%20new%20stuff"
        ).map(String::toCharArray)
            .map(arr -> Arguments.of(arr, arr));
    }
}
