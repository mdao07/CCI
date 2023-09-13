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
    void URLify_positiveScenarios(char [] origin, char [] target) {
        URLify(origin);
        assertArrayEquals(origin, target);
    }

    private static Stream<Arguments> getPositiveArguments() {
        return Stream.of(
                Arguments.of("Mr John Smith    ".toCharArray(), "Mr%20John%20Smith".toCharArray())
        );
    }
}
