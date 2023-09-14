package chapter1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static chapter1.Ex6.compress;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex6_test {

    @ParameterizedTest
    @ValueSource(strings = { "aaabbbccc", "aaaaaaaaaaabbbbbbbbbbbcccc" })
    void compress_positiveScenarios(String text) {
        String result = compress(text);
        assertTrue(result.length() < text.length());
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = { "abc", "aabbcc" })
    void compress_negativeScenarios(String text) {
        String result = compress(text);
        assertTrue(result.length() == text.length());
    }

    @Test
    void compress_nullScenario() {
        String result = compress(null);
        assertEquals(null, result);
    }
}
